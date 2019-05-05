@file:Suppress("unused")

package androidovshchik.constraintweb.extensions

import android.webkit.CookieManager
import androidovshchik.constraintweb.ConstraintWebLayout

fun CookieManager.setAcceptThirdPartyCookies(webLayout: ConstraintWebLayout?, accept: Boolean) {
}

fun CookieManager.acceptThirdPartyCookies(webLayout: ConstraintWebLayout?): Boolean {
    return true
}