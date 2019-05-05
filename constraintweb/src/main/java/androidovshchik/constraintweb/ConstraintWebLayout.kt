@file:Suppress("unused")

package androidovshchik.constraintweb

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.AttributeSet
import android.webkit.DownloadListener
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.FrameLayout

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

    override fun setWebViewClient(client: WebViewClient) {
        checkThread()
    }

    override fun getWebViewClient(): WebViewClient? {
        checkThread()
        return null
    }

    override fun setDownloadListener(listener: DownloadListener) {
        checkThread()
    }

    override fun setWebChromeClient(client: WebChromeClient) {
        checkThread()
    }

    override fun getWebChromeClient(): WebChromeClient? {
        checkThread()
        return null
    }

    override fun restoreState(inState: Bundle): WebBackForwardList? {
        checkThread()
        return null
    }

    override fun destroy() {
        checkThread()
    }

    private fun checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw RuntimeException("A ConstraintWebLayout method must be called on main thread")
        }
    }
}