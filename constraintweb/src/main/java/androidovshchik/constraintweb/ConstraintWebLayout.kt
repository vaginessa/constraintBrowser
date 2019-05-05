@file:Suppress("unused")

package androidovshchik.constraintweb

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.AttributeSet
import android.view.ViewGroup
import android.webkit.DownloadListener
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.FrameLayout
import org.jsoup.nodes.Document
import org.jsoup.parser.Tag

open class ConstraintWebLayout : FrameLayout, ConstraintWebRepository, ConstraintWebView {

    protected lateinit var presenter: ConstraintWebPresenter

    protected var initialUrl = "about:blank"

    protected var currentUrl = initialUrl

    protected var data = ""

    protected var styles = ""

    protected var scripts = ""

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

    override fun getUrl(): String {
        checkThread()
        return currentUrl
    }

    override fun getOriginalUrl(): String {
        checkThread()
        return initialUrl
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

    override fun setDocument(document: Document) {
        checkThread()
        val html = ConstraintWebElement(context.applicationContext).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            tag = Tag.valueOf("html")
        }
        val body = ConstraintWebElement(context.applicationContext).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            tag = Tag.valueOf("body")
        }
        html.addView(body)
        addView(html)
        body.init(document.body())
    }

    override fun reload() {
        checkThread()
        presenter.stopLoading()
        presenter.loadUrl(getUrl())
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

    override fun stopLoading() {
        checkThread()
        presenter.stopLoading()
    }

    override fun clearCache(includeDiskFiles: Boolean) {
        checkThread()
        presenter.clearCache(includeDiskFiles)
    }

    override fun destroy() {
        checkThread()
        presenter.destroy()
    }

    protected fun checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw RuntimeException("A ConstraintWebLayout's method must be called on main thread")
        }
    }
}