@file:Suppress("unused")

package androidovshchik.constraintweb

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.AttributeSet
import android.webkit.*
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import org.jsoup.nodes.Document
import org.jsoup.parser.Tag

open class ConstraintWebLayout : LinearLayout, ConstraintWebRepository, ConstraintWebView {

    protected lateinit var presenter: ConstraintWebPresenter

    /**
     * Only for debug purposes
     */
    protected var webView: WebView? = null

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
        orientation = VERTICAL
        if (isDebug()) {
            weightSum = 2f
            webView = WebView(context).apply {
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    0,
                    1f
                )
            }
            addView(webView)
        }
    }

    override fun isDebug(): Boolean {
        checkThread()
        return true
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
        removeAllViewsInLayout()
        val html = ConstraintWebElement(context.applicationContext).apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                if (isDebug()) 0 else LayoutParams.MATCH_PARENT,
                if (isDebug()) 1f else 0f
            )
            tag = Tag.valueOf("html")
        }
        val body = ConstraintWebElement(context.applicationContext).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            tag = Tag.valueOf("body")
        }
        html.addView(body)
        addView(html)
        html.init(document.head())
        body.init(document.body())
    }

    override fun addStyleSheet(style: String) {
        checkThread()
        styles += style
    }

    override fun addDOMScript(script: String) {
        checkThread()
        scripts += script
    }

    override fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        checkThread()
        webView?.loadUrl(url, additionalHttpHeaders)
        presenter.loadUrl(url, additionalHttpHeaders)
    }

    override fun loadUrl(url: String) {
        checkThread()
        webView?.loadUrl(url)
        presenter.loadUrl(url)
    }

    override fun postUrl(url: String, postData: ByteArray) {
        checkThread()
        webView?.postUrl(url, postData)
        presenter.postUrl(url, postData)
    }

    override fun loadData(data: String, mimeType: String?, encoding: String?) {
        checkThread()
        webView?.loadData(data, mimeType, encoding)
        presenter.loadData(data, mimeType, encoding)
    }

    override fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?) {
        checkThread()
        webView?.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
        presenter.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
    }

    override fun stopLoading() {
        checkThread()
        webView?.stopLoading()
        presenter.stopLoading()
    }

    override fun reload() {
        checkThread()
        webView?.reload()
        presenter.reload()
    }

    override fun clearCache(includeDiskFiles: Boolean) {
        checkThread()
        webView?.clearCache(includeDiskFiles)
        presenter.clearCache(includeDiskFiles)
    }

    override fun destroy() {
        checkThread()
        webView?.destroy()
        presenter.destroy()
    }

    protected fun checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw RuntimeException("A ConstraintWebLayout's method must be called on main thread")
        }
    }
}