package androidovshchik.constraintweb

import android.webkit.WebViewClient
import java.lang.ref.WeakReference

/**
 * All parameters [android.webkit.WebView] in callback methods will be null
 */
open class ConstraintWebViewClient(view: ConstraintWebView) : WebViewClient() {

    protected val webLayout = WeakReference(view)
}