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

    override var debug = true
        get() {
            checkThread()
            return field
        }
        set(value) {
            checkThread()
            field = value
            if (value) {
                webView = WebView(context).apply {
                    id = R.id.constraint_web_debug_view
                    layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 1f)
                }
                addView(webView)
            } else {

            }
        }

    override var data = ""
        get() {
            checkThread()
            return field
        }
        set(value) {
            checkThread()
            field = value
        }

    override val styles = arrayListOf<String>()
        get() {
            checkThread()
            return field
        }

    override val scripts = arrayListOf<String>()
        get() {
            checkThread()
            return field
        }

    override var url = BLANK_PAGE
        get() {
            checkThread()
            return field
        }
        @Suppress("UNUSED_PARAMETER")
        set(value) {
            checkThread()
        }

    override var originalUrl = BLANK_PAGE
        get() {
            checkThread()
            return field
        }
        @Suppress("UNUSED_PARAMETER")
        set(value) {
            checkThread()
        }

    override var webViewClient: WebViewClient? = null
        get() {
            checkThread()
            return field
        }
        set(value) {
            checkThread()
            field = value
        }

    override var webChromeClient: WebChromeClient? = null
        get() {
            checkThread()
            return field
        }
        set(value) {
            checkThread()
            field = value
        }

    override var downloadListener: DownloadListener? = null
        get() {
            checkThread()
            return field
        }
        set(value) {
            checkThread()
            field = value
        }

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
    }

    override fun setDocument(document: Document) {
        checkThread()
        removeAllViewsInLayout()
        val html = ConstraintWebElement(context.applicationContext).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 1f)
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

    override fun restoreState(inState: Bundle): WebBackForwardList? {
        checkThread()
        return null
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

    protected open fun checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw RuntimeException("A ConstraintWebLayout's method must be called on main thread")
        }
    }

    companion object {

        const val BLANK_PAGE = "about:blank"
    }
}