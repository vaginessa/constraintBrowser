package androidovshchik.constraintweb

import android.webkit.WebView.HitTestResult.UNKNOWN_TYPE

class HitTestResult {

    var type = UNKNOWN_TYPE

    var extra: String? = null
}