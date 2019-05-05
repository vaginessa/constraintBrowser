@file:Suppress("unused")

package androidovshchik.constraintweb

import android.content.Context
import android.webkit.WebViewDatabase
import java.lang.ref.WeakReference

open class ConstraintWebDatabase(context: Context) : WebViewDatabase() {

    private val context = WeakReference(context)

    override fun hasHttpAuthUsernamePassword(): Boolean {
        return false
    }

    override fun clearHttpAuthUsernamePassword() {

    }

    override fun setHttpAuthUsernamePassword(host: String?, realm: String?, username: String?, password: String?) {

    }

    override fun clearUsernamePassword() {

    }

    override fun hasFormData(): Boolean {
        return false
    }

    override fun hasUsernamePassword(): Boolean {
        return false
    }

    override fun getHttpAuthUsernamePassword(host: String?, realm: String?): Array<String>? {
        return null
    }

    override fun clearFormData() {

    }
}