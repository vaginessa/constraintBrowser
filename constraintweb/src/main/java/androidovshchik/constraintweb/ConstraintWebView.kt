package androidovshchik.constraintweb

import android.content.Context
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import org.jsoup.nodes.Document

interface ConstraintWebView {

    var debug: Boolean

    fun getContext(): Context

    fun getUrl(): String

    fun getOriginalUrl(): String

    /**
     * All instances of parameter [android.webkit.WebView] in callback methods will be null
     */
    fun setWebViewClient(client: WebViewClient)

    /**
     * All instances of parameter [android.webkit.WebView] in callback methods will be null
     */
    fun getWebViewClient(): WebViewClient?

    fun setDownloadListener(listener: DownloadListener)

    /**
     * All instances of parameter [android.webkit.WebView] in callback methods will be null
     */
    fun setWebChromeClient(client: WebChromeClient)

    /**
     * All instances of parameter [android.webkit.WebView] in callback methods will be null
     */
    fun getWebChromeClient(): WebChromeClient?

    fun setDocument(document: Document)

    fun addStyleSheet(style: String)

    fun addDOMScript(script: String)

    /**
     * @return is always null
     */
    fun restoreState(inState: Bundle): WebBackForwardList?
}