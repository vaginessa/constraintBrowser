package androidovshchik.constraintweb

import android.webkit.WebChromeClient
import java.lang.ref.WeakReference

/**
 * All parameters [android.webkit.WebView] in callback methods will be null
 */
open class ConstraintWebChromeClient(view: ConstraintWebView) : WebChromeClient() {

    protected val webLayout = WeakReference(view)
}