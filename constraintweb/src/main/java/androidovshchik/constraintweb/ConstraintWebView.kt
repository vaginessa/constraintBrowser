package androidovshchik.constraintweb

import android.content.Context
import android.os.Bundle
import android.webkit.*
import org.jsoup.nodes.Document

interface ConstraintWebView {

    var debug: Boolean

    /**
     * Full html code of webpage including <iframe> tags
     */
    var data: String

    val styles: ArrayList<String>

    val scripts: ArrayList<String>

    /**
     * Readonly field
     */
    var url: String

    /**
     * Readonly field
     */
    var originalUrl: String

    val settings: WebSettings

    /**
     * All parameters [android.webkit.WebView] in callback methods will be null
     */
    var webViewClient: WebViewClient?

    /**
     * All parameters [android.webkit.WebView] in callback methods will be null
     */
    var webChromeClient: WebChromeClient?

    var downloadListener: DownloadListener?

    fun setDocument(document: Document)

    fun getContext(): Context

    /**
     * @return is always null
     */
    fun restoreState(inState: Bundle): WebBackForwardList?
}