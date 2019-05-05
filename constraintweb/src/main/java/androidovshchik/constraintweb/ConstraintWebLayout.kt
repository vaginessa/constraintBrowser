@file:Suppress("unused")

package androidovshchik.constraintweb

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.AttributeSet
import android.widget.FrameLayout
import okhttp3.OkHttpClient

open class ConstraintWebLayout : FrameLayout, ConstraintWebRepository, ConstraintWebView {

    private lateinit var presenter: ConstraintWebPresenter

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        presenter = ConstraintWebPresenter(this)
    }

    override fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        checkThread()
        presenter.loadUrl(url, additionalHttpHeaders)
    }

    override fun loadUrl(url: String) {
        checkThread()
        presenter.loadUrl(url)
    }

    override fun postUrl(url: String, postData: ByteArray) {
        checkThread()
        presenter.postUrl(url, postData)
    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {
        checkThread()
        presenter.loadData(data, mimeType, encoding)
    }

    override fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {
        checkThread()
        presenter.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
    }

    override fun clearCache(includeDiskFiles: Boolean) {
        checkThread()
        presenter.clearCache(includeDiskFiles)
    }

    override fun restoreState(inState: Bundle) {
        checkThread()
    }

    private fun checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw RuntimeException("A ConstraintWebLayout method must be called on main thread")
        }
    }

    companion object {

        private val httpClient = OkHttpClient().apply {
            dispatcher().maxRequests = 4
        }
    }
}