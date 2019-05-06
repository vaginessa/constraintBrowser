package androidovshchik.constraintweb

import android.net.Uri
import android.webkit.URLUtil
import androidovshchik.constraintweb.extensions.await
import kotlinx.coroutines.*
import okhttp3.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import timber.log.Timber
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
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
        loadHtml(url, additionalHttpHeaders, null)
    }

    override fun loadUrl(url: String) {
        loadHtml(url, null, null)
    }

    override fun postUrl(url: String, postData: ByteArray) {
        loadHtml(url, null, postData)
    }

    private fun loadHtml(url: String, additionalHttpHeaders: Map<String, String>?, postData: ByteArray?) {
        launch {
            val html = when (val response = loadUrl(url, additionalHttpHeaders, postData)) {
                is InputStream -> {
                    withContext(Dispatchers.IO) {
                        response.bufferedReader()
                            .use(BufferedReader::readText)
                    }
                }
                is Response -> {
                    response.body()?.string() ?: ""
                }
                else -> return@launch
            }
            val document = parseHtml(null, html, null, null, null)
            document.location()
            view.get()?.setDocument(document)
        }
    }

    private suspend fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>?, postData: ByteArray?): Any? {
        var formattedUrl = url.trim()
        if (formattedUrl.startsWith("//")) {
            formattedUrl = "http:$formattedUrl"
        }
        return when {
            URLUtil.isAssetUrl(formattedUrl) -> {
                view.get()?.getContext()?.assets
                    ?.open(Uri.parse(formattedUrl)?.path.toString())
            }
            isResourceUrl(formattedUrl) -> {
                view.get()?.getContext()?.let {
                    val name = Uri.parse(formattedUrl).lastPathSegment
                        ?.split(".")
                        ?.get(0).toString()
                    val id = it.resources.getIdentifier(name, "raw", it.packageName)
                    it.resources.openRawResource(id)
                }
            }
            URLUtil.isFileUrl(formattedUrl) -> {
                File(Uri.parse(formattedUrl).path).inputStream()
            }
            URLUtil.isNetworkUrl(formattedUrl) -> {
                httpClient.newCall(Request.Builder()
                    .url(formattedUrl)
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
            }
            else -> null
        }
    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {
        loadDataWithBaseURL(null, data, mimeType, encoding, null)
    }

    override fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {
        launch {
            parseHtml(baseUrl, data, mimeType, encoding, historyUrl)
        }
    }

    private suspend fun parseHtml(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?): Document {
        return withContext(Dispatchers.IO) {
            Jsoup.parse(data, baseUrl ?: "").apply {
                select("style")
                    .forEach {
                        view.get()?.styles?.add(it.data())
                    }
                select("link[href]")
                    .forEach {
                        launch {
                            loadUrl(it.attributes().getIgnoreCase("href"), null, null)?.let {
                                if () {

                                }
                            }
                            //if (".*.(html|css|js|eot|otf|ttf|woff|woff2)$".toRegex(setOf(RegexOption.IGNORE_CASE)).matches(formattedUrl))
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
                            view.get()?.scripts?.add(it.data())
                            return@forEach
                        }
                        launch {
                            loadUrl(it.attributes().getIgnoreCase("src"), null, null)?.let {
                                if () {

                                }
                            }
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
            loadUrl(it.url)
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