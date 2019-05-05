package androidovshchik.constraintweb

import android.net.Uri
import android.webkit.URLUtil
import androidovshchik.constraintweb.extensions.await
import kotlinx.coroutines.*
import okhttp3.*
import timber.log.Timber
import java.io.BufferedReader
import java.io.File
import java.lang.ref.WeakReference

class ConstraintWebPresenter(view: ConstraintWebView) : CoroutineScope, ConstraintWebRepository {

    private val job = SupervisorJob()

    override val coroutineContext = Dispatchers.Main + job

    private val view = WeakReference(view)

    override fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        loadUrl(url, additionalHttpHeaders, null)
    }

    override fun loadUrl(url: String) {
        loadUrl(url, null, null)
    }

    override fun postUrl(url: String, postData: ByteArray) {
        loadUrl(url, null, postData)
    }

    private fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>?, postData: ByteArray?) {
        launch {
            try {
                when {
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
                                if (postData != null) {
                                    post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), postData))
                                } else {
                                    get()
                                }
                                if (additionalHttpHeaders != null) {
                                    headers(Headers.of(additionalHttpHeaders))
                                }
                            }
                            .build())
                            .await()
                            .body()
                            .use { it?.string() }
                    }
                    else -> return@launch
                }?.let {
                    loadDataWithBaseURL(null, it, null, null, null)
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {

    }

    override fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {

    }

    override fun clearCache(includeDiskFiles: Boolean) {

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