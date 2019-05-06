package androidovshchik.constraintweb

import android.content.Context
import android.os.Bundle
import android.os.Message
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

    val history: ArrayList<String>

    /**
     * Readonly field
     */
    var url: String

    /**
     * Readonly field
     */
    var originalUrl: String

    /**
     * Readonly field
     */
    var title: String

    /**
     * Readonly field
     */
    var progress: Int

    val hitTestResult: HitTestResult

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

    fun getContext(): Context

    /**
     * @return is always null
     */
    fun saveState(outState: Bundle): WebBackForwardList?

    /**
     * @return is always null
     */
    fun restoreState(inState: Bundle): WebBackForwardList?

    fun pauseTimers()

    fun resumeTimers()

    fun onPause()

    fun onResume()

    fun canGoBack(): Boolean

    fun goBack()

    fun canGoForward(): Boolean

    fun goForward()

    fun clearHistory()

    fun findNext(forward: Boolean)

    fun findAllAsync(find: String)

    fun clearMatches()

    fun setNetworkAvailable(networkUp: Boolean)

    fun requestFocusNodeHref(hrefMsg: Message?)

    fun setDocument(document: Document)
}