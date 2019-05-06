@file:Suppress("unused")

package androidovshchik.constraintweb.jbridge

import android.content.Context
import com.eclipsesource.v8.V8
import timber.log.Timber

class LocalStorage(v8: V8, context: Context, name: String) : JObject(v8, "localStorage") {

    private val preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    init {
        preferences.all.filter { !methodNames.contains(it.key) }.forEach {
            v8Object.add(it.key, "${it.value}")
        }
    }

    fun setItem(key: Any?, value: Any?) {
        if (!methodNames.contains("$key")) {
            v8Object.add("$key", "$value")
            preferences.edit()
                .putString("$key", "$value")
                .apply()
        } else {
            Timber.w("Attempt of setting method '$key'")
        }
    }

    fun getItem(key: Any?): Any? {
        return preferences.getString("$key", null)
    }

    fun removeItem(key: Any?) {
        if (!methodNames.contains("$key")) {
            v8Object.addUndefined("$key")
            preferences.edit()
                .remove("$key")
                .apply()
        } else {
            Timber.w("Attempt of removing method '$key'")
        }
    }

    fun key(index: Any?): String? {
        "$index".toIntOrNull()?.let { position ->
            var counter = 0
            preferences.all.keys.filter { !methodNames.contains(it) }.forEach {
                if (counter == position) {
                    return it
                }
                counter++
            }
        }
        return null
    }

    fun clear() {
        v8Object.keys.filter { !methodNames.contains(it) }.forEach {
            v8Object.addUndefined(it)
        }
        preferences.edit()
            .clear()
            .apply()
    }

    override fun onStop() {
        preferences.edit().apply {
            v8Object.keys.filter { !methodNames.contains(it) }.forEach {
                putString(it, "${v8Object[it]}")
            }
            apply()
        }
    }
}