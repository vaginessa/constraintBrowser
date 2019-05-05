package androidovshchik.constraintweb

import android.net.Uri
import android.webkit.URLUtil
import androidovshchik.constraintweb.extensions.await
import kotlinx.coroutines.*
import okhttp3.*
import org.jsoup.Jsoup
import timber.log.Timber
import java.io.BufferedReader
import java.io.File
import java.lang.ref.WeakReference

class ConstraintWebPresenter(view: ConstraintWebView) : CoroutineScope, ConstraintWebRepository {

    private val job = SupervisorJob()

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        if (e !is CancellationException) {
            Timber.e(e)
        }
    }

    private val view = WeakReference(view)

    override fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        launch {
            loadUrl(url, additionalHttpHeaders, null)
        }
    }

    override fun loadUrl(url: String) {
        launch {
            loadUrl(url, null, null)
        }
    }

    override fun postUrl(url: String, postData: ByteArray) {
        launch {
            loadUrl(url, null, postData)
        }
    }

    private suspend fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>?, postData: ByteArray?): Any? {
        return when {
            URLUtil.isAssetUrl(url.trim()) -> {
                view.get()?.getContext()?.let {
                    withContext(Dispatchers.IO) {
                        it.assets.open(Uri.parse(url.trim())?.path.toString())
                            .bufferedReader()
                            .use(BufferedReader::readText)
                    }
                }
            }
            isResourceUrl(url.trim()) -> {
                view.get()?.getContext()?.let {
                    withContext(Dispatchers.IO) {
                        val name = Uri.parse(url.trim()).lastPathSegment
                            ?.split(".")
                            ?.get(0).toString()
                        val id = it.resources.getIdentifier(name, "raw", it.packageName)
                        it.resources.openRawResource(id)
                            .bufferedReader()
                            .use(BufferedReader::readText)
                    }
                }
            }
            URLUtil.isFileUrl(url.trim()) -> {
                withContext(Dispatchers.IO) {
                    File(Uri.parse(url.trim()).path)
                        .bufferedReader()
                        .use(BufferedReader::readText)
                }
            }
            URLUtil.isNetworkUrl(url.trim()) -> {
                httpClient.newCall(Request.Builder()
                    .url(url.trim())
                    .apply {
                        if (additionalHttpHeaders != null) {
                            headers(Headers.of(additionalHttpHeaders))
                        }
                        if (postData != null) {
                            post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), postData))
                        }
                    }
                    .build())
                    .await()
                    .body()
            }
            else -> null
        }
    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {
        launch {
            loadDataWithBaseURL(null, data, mimeType, encoding, null)
        }
    }

    override suspend fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {
        withContext(Dispatchers.IO) {
            Jsoup.parse(data).apply {
                select("style")
                    .forEach {
                        view.get()?.addStyleSheet("${it.data()}\n")
                    }
                select("link[href]")
                    .forEach {
                        launch {
                            val call = loadUrl(it.attributes().getIgnoreCase("href"), null, null)
                                ?: return@forEach
                            val resource = call.await().body()
                            when ("${resource?.contentType()?.type()}/${resource?.contentType()?.subtype()}".toLowerCase()) {
                                "text/css" -> {
                                    styles += "${resource?.string() ?: ""}\n"
                                }
                                "application/octet-stream" -> {

                                }
                            }
                        }
                    }
                select("script")
                    .forEach {
                        if (!it.attributes().hasKeyIgnoreCase("src")) {
                            view.get()?.addDOMScript("${it.data()}\n")
                            return@forEach
                        }
                        launch {
                            val call = loadUrl(it.attributes().getIgnoreCase("src"), tag)
                                ?: return@forEach
                            val resource = call.await().body()
                            when ("${resource?.contentType()?.type()}/${resource?.contentType()?.subtype()}".toLowerCase()) {
                                "application/javascript", "application/x-javascript" -> {
                                    scripts += "${resource?.string() ?: ""}\n"
                                }
                            }
                        }
                    }
            }
        }
    }

    override fun stopLoading() {
        job.cancelChildren()
    }

    override fun reload() {
        stopLoading()
        view.get()?.let {
            loadUrl(it.getUrl())
        }
    }

    override fun clearCache(includeDiskFiles: Boolean) {
    }

    override fun destroy() {
        stopLoading()
        job.cancel()
    }

    companion object {

        const val RESOURCE_BASE = "file:///android_res/"

        private val httpClient = OkHttpClient().apply {
            dispatcher().maxRequests = 4
        }

        @JvmStatic
        fun isResourceUrl(url: String?): Boolean {
            return null != url && url.startsWith(RESOURCE_BASE)
        }
    }
}