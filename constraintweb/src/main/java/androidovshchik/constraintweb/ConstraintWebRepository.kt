package androidovshchik.constraintweb

internal interface ConstraintWebRepository {

    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>)

    fun loadUrl(url: String)

    fun postUrl(url: String, postData: ByteArray)

    fun loadData(data: String, mimeType: String?, encoding: String?)

    fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?)

    fun stopLoading()

    fun clearCache(includeDiskFiles: Boolean)

    fun destroy()
}