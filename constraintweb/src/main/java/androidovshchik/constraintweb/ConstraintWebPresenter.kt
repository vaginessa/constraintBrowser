package androidovshchik.constraintweb

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.lang.ref.WeakReference

class ConstraintWebPresenter(view: ConstraintWebView) : CoroutineScope, ConstraintWebRepository {

    private val job = SupervisorJob()

    override val coroutineContext = Dispatchers.Main + job

    private val view = WeakReference(view)

    override fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {

    }

    override fun loadUrl(url: String) {

    }

    override fun postUrl(url: String, postData: ByteArray) {

    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {

    }

    override fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {

    }

    override fun clearCache(includeDiskFiles: Boolean) {

    }
}