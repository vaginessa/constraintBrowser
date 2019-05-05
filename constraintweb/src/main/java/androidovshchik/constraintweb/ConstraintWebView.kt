package androidovshchik.constraintweb

import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebViewClient

interface ConstraintWebView {

    fun setWebViewClient(client: WebViewClient)

    fun getWebViewClient(): WebViewClient?

    fun setDownloadListener(listener: DownloadListener)

    fun setWebChromeClient(client: WebChromeClient)

    fun getWebChromeClient(): WebChromeClient?

    fun restoreState(inState: Bundle): WebBackForwardList?

    fun destroy()
}