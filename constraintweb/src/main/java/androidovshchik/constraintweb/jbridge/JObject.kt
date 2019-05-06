@file:Suppress("unused")

package androidovshchik.constraintweb.jbridge

import com.eclipsesource.v8.V8
import com.eclipsesource.v8.V8Object
import timber.log.Timber

@Suppress("LeakingThis")
open class JObject(v8: V8, key: String) {

    protected val v8Object: V8Object = V8Object(v8)

    protected val methodNames = arrayListOf<String>()

    init {
        try {
            javaClass.declaredMethods.forEach {
                if (!it.name.contains("$") && it.name != "onStop" && it.name != "onDestroy") {
                    methodNames.add(it.name)
                    v8Object.registerJavaMethod(this, it.name, it.name, it.parameterTypes)
                }
            }
            v8.add(key, v8Object)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    open fun onStop() {}

    open fun onDestroy() {
        v8Object.release()
    }
}