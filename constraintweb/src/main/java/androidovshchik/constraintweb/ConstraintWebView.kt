package androidovshchik.constraintweb

import android.content.Context
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import org.jsoup.nodes.Document

interface ConstraintWebView {

    fun getContext(): Context

    fun getUrl(): String

    fun getOriginalUrl(): String

    /**
     * All instances of parameter [android.webkit.WebView] will be null in callback methods of client
     */
    fun setWebViewClient(client: WebViewClient)

    /**
     * All instances of parameter [android.webkit.WebView] will be null in callback methods of client
     */
    fun getWebViewClient(): WebViewClient?

    fun setDownloadListener(listener: DownloadListener)

    /**
     * All instances of parameter [android.webkit.WebView] will be null in callback methods of client
     */
    fun setWebChromeClient(client: WebChromeClient)

    /**
     * All instances of parameter [android.webkit.WebView] will be null in callback methods of client
     */
    fun getWebChromeClient(): WebChromeClient?

    /**
     * Return result is always null
     */
    fun restoreState(inState: Bundle): WebBackForwardList?

    fun setDocument(document: Document)

    fun addStyleSheet(style: String)

    fun addDOMScript(script: String)

    fun reload()
}