package androidovshchik.constraintweb

internal interface ConstraintWebRepository {

    /**
     * @param url must contains an uri of the file with html code
     */
    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>)

    /**
     * @param url must contains an uri of the file with html code
     */
    fun loadUrl(url: String)

    /**
     * @param url must contains an uri of the file with html code
     */
    fun postUrl(url: String, postData: ByteArray)

    /**
     * @param data must contains html code
     * @param mimeType is not used
     * @param encoding is not used
     */
    fun loadData(data: String, mimeType: String?, encoding: String?)

    /**
     * @param data must contains html code
     * @param mimeType is not used
     * @param encoding is not used
     * @param historyUrl is not used
     */
    fun loadDataWithBaseURL(baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?)

    fun stopLoading()

    fun reload()

    fun clearCache(includeDiskFiles: Boolean)

    fun destroy()
}