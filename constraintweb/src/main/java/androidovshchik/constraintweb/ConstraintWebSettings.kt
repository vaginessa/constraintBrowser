package androidovshchik.constraintweb

import android.webkit.WebSettings
import java.lang.ref.WeakReference

/**
 * All parameters [android.webkit.WebView] in callback methods will be null
 */
open class ConstraintWebSettings(view: ConstraintWebView) : WebSettings() {

    protected val webLayout = WeakReference(view)

    private var blockNetworkImage = false
    private var javaScriptEnabled = false
    private var javaScriptCanOpenWindowAutomatically = false
    private var lightTouchEnabled = false
    private var needInitialFocus = false
    private var renderPriority = RenderPriority.NORMAL
    private var saveFormData = false
    private var supportMultipleWindows = false
    private var supportZoom = true
    private var useWideViewPort = false
    private var cacheMode: Int = 0
    private var layoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS
    private var defaultTextEncoding = "UTF-8"
    private var defaultFontSize = 16
    private var loadsImagesAutomatically: Boolean = false
    private var defaultFixedFontSize: Int = 0
    private var minimumLogicalFontSize: Int = 0
    private var minimumFontSize: Int = 0
    private var fantasyFontFamily: String? = null
    private var cursiveFontFamily: String? = null
    private var serifFontFamily: String? = null
    private var sansSerifFontFamily: String? = null
    private var fixedFontFamily: String? = null
    private var standardFontFamily: String? = null
    private var savePassword: Boolean = false

    private var allowFileAccess = true
    private var builtInZoomControls = true
    private var userAgentString: String? = "Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"

    private var databaseEnabled = false
    private var databasePath = "database"
    private var geolocationDatabasePath = "geolocation"
    private var geolocationEnabled = false

    private var defaultZoom: ZoomDensity? = null
    private var domStorageEnabled = false
    private var loadWithOverviewMode = false
    private var appCacheEnabled = false
    private var appCacheMaxSize: Long = 0
    private var appCachePath = "appcache"

    private var blockNetworkLoads = false
    private var pluginState: PluginState = PluginState.OFF

    private var mixedContentMode = 0
    private var allowContentAccess = true
    private var displayZoomControls: Boolean = false
    private var textZoom = 100
    private var allowFileAccessFromFile = true
    private var allowUniversalAccessFromFile = true
    private var mediaPlaybackRequiresUserGesture = true
    private var enableSmoothTransition: Boolean = false

    @Synchronized
    override fun getBlockNetworkImage(): Boolean {
        return blockNetworkImage
    }

    @Synchronized
    override fun setBlockNetworkImage(flag: Boolean) {
        blockNetworkImage = flag
    }

    @Synchronized
    override fun getJavaScriptEnabled(): Boolean {
        return javaScriptEnabled
    }

    @Synchronized
    override fun setJavaScriptEnabled(flag: Boolean) {
        javaScriptEnabled = flag
    }

    override fun getLightTouchEnabled(): Boolean {
        return lightTouchEnabled
    }

    override fun setLightTouchEnabled(flag: Boolean) {
        lightTouchEnabled = flag
    }

    override fun setNeedInitialFocus(flag: Boolean) {
        needInitialFocus = flag
    }

    @Synchronized
    override fun setRenderPriority(priority: RenderPriority) {
        renderPriority = priority
    }

    @Synchronized
    override fun setSupportMultipleWindows(support: Boolean) {
        supportMultipleWindows = support
    }

    override fun setSupportZoom(support: Boolean) {
        supportZoom = support
    }

    override fun setCacheMode(mode: Int) {
        this.cacheMode = mode
    }

    override fun getCacheMode(): Int {
        return cacheMode
    }

    override fun getUseWideViewPort(): Boolean {
        return useWideViewPort
    }

    override fun setUseWideViewPort(useWideViewPort: Boolean) {
        this.useWideViewPort = useWideViewPort
    }

    override fun getSaveFormData(): Boolean {
        return saveFormData
    }

    override fun setSaveFormData(saveFormData: Boolean) {
        this.saveFormData = saveFormData
    }

    override fun setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowAutomatically: Boolean) {
        this.javaScriptCanOpenWindowAutomatically = javaScriptCanOpenWindowAutomatically
    }

    override fun getJavaScriptCanOpenWindowsAutomatically(): Boolean {
        return this.javaScriptCanOpenWindowAutomatically
    }

    @Synchronized
    override fun setLayoutAlgorithm(algorithm: LayoutAlgorithm) {
        this.layoutAlgorithm = algorithm
    }

    override fun getDefaultTextEncodingName(): String {
        return this.defaultTextEncoding
    }

    override fun setDefaultTextEncodingName(defaultTextEncoding: String) {
        this.defaultTextEncoding = defaultTextEncoding
    }

    override fun getDefaultFontSize(): Int {
        return defaultFontSize
    }

    override fun setDefaultFontSize(defaultFontSize: Int) {
        this.defaultFontSize = defaultFontSize
    }

    override fun getLoadsImagesAutomatically(): Boolean {
        return loadsImagesAutomatically
    }

    override fun setLoadsImagesAutomatically(loadsImagesAutomatically: Boolean) {
        this.loadsImagesAutomatically = loadsImagesAutomatically
    }

    override fun getDefaultFixedFontSize(): Int {
        return defaultFixedFontSize
    }

    override fun setDefaultFixedFontSize(defaultFixedFontSize: Int) {
        this.defaultFixedFontSize = defaultFixedFontSize
    }

    override fun getMinimumLogicalFontSize(): Int {
        return minimumLogicalFontSize
    }

    override fun setMinimumLogicalFontSize(minimumLogicalFontSize: Int) {
        this.minimumLogicalFontSize = minimumLogicalFontSize
    }

    override fun getMinimumFontSize(): Int {
        return minimumFontSize
    }

    override fun setMinimumFontSize(minimumFontSize: Int) {
        this.minimumFontSize = minimumFontSize
    }

    override fun getFantasyFontFamily(): String {
        return fantasyFontFamily
    }

    override fun setFantasyFontFamily(fantasyFontFamily: String) {
        this.fantasyFontFamily = fantasyFontFamily
    }

    override fun getCursiveFontFamily(): String {
        return cursiveFontFamily
    }

    override fun setCursiveFontFamily(cursiveFontFamily: String) {
        this.cursiveFontFamily = cursiveFontFamily
    }

    override fun getSerifFontFamily(): String {
        return serifFontFamily
    }

    override fun setSerifFontFamily(serifFontFamily: String) {
        this.serifFontFamily = serifFontFamily
    }

    override fun getSansSerifFontFamily(): String {
        return sansSerifFontFamily
    }

    override fun setSansSerifFontFamily(sansSerifFontFamily: String) {
        this.sansSerifFontFamily = sansSerifFontFamily
    }

    override fun getFixedFontFamily(): String {
        return fixedFontFamily
    }

    override fun setFixedFontFamily(fixedFontFamily: String) {
        this.fixedFontFamily = fixedFontFamily
    }

    override fun getStandardFontFamily(): String {
        return standardFontFamily
    }

    override fun setStandardFontFamily(standardFontFamily: String) {
        this.standardFontFamily = standardFontFamily
    }

    override fun getLayoutAlgorithm(): LayoutAlgorithm {
        return layoutAlgorithm
    }

    override fun supportMultipleWindows(): Boolean {
        return supportMultipleWindows
    }

    override fun getSavePassword(): Boolean {
        return savePassword
    }

    override fun setSavePassword(savePassword: Boolean) {
        this.savePassword = savePassword
    }

    override fun supportZoom(): Boolean {
        return supportZoom
    }

    override fun getAllowFileAccess(): Boolean {
        return allowFileAccess
    }

    override fun setAllowFileAccess(allow: Boolean) {
        allowFileAccess = allow
    }

    override fun getBuiltInZoomControls(): Boolean {
        return builtInZoomControls
    }

    override fun setBuiltInZoomControls(enabled: Boolean) {
        builtInZoomControls = enabled
    }

    @Synchronized
    override fun setUserAgentString(ua: String?) {
        userAgentString = ua
    }

    @Synchronized
    override fun getUserAgentString(): String? {
        return userAgentString
    }
    // End API 3

    @Synchronized
    override fun getDatabaseEnabled(): Boolean {
        return databaseEnabled
    }

    @Synchronized
    override fun setDatabaseEnabled(flag: Boolean) {
        databaseEnabled = flag
    }

    @Synchronized
    override fun setDatabasePath(path: String) {
        databasePath = path
    }

    @Synchronized
    override fun getDatabasePath(): String {
        return databasePath
    }

    override fun setGeolocationDatabasePath(geolocationDatabasePath: String) {
        this.geolocationDatabasePath = geolocationDatabasePath
    }

    override fun setGeolocationEnabled(geolocationEnabled: Boolean) {
        this.geolocationEnabled = geolocationEnabled
    }
    // End API 5

    override fun setDefaultZoom(zoom: ZoomDensity) {
        this.defaultZoom = zoom
    }

    override fun getDefaultZoom(): ZoomDensity? {
        return defaultZoom
    }

    @Synchronized
    override fun getDomStorageEnabled(): Boolean {
        return domStorageEnabled
    }

    @Synchronized
    override fun setDomStorageEnabled(flag: Boolean) {
        domStorageEnabled = flag
    }

    override fun getLoadWithOverviewMode(): Boolean {
        return loadWithOverviewMode
    }

    override fun setLoadWithOverviewMode(flag: Boolean) {
        loadWithOverviewMode = flag
    }

    override fun setAppCacheEnabled(appCacheEnabled: Boolean) {
        this.appCacheEnabled = appCacheEnabled
    }

    override fun setAppCacheMaxSize(appCacheMaxSize: Long) {
        this.appCacheMaxSize = appCacheMaxSize
    }

    override fun setAppCachePath(appCachePath: String) {
        this.appCachePath = appCachePath
    }
    // End API 7

    @Synchronized
    override fun getBlockNetworkLoads(): Boolean {
        return blockNetworkLoads
    }

    @Synchronized
    override fun setBlockNetworkLoads(flag: Boolean) {
        blockNetworkLoads = flag
    }

    @Synchronized
    override fun getPluginState(): PluginState {
        return pluginState
    }

    @Synchronized
    override fun setPluginState(state: PluginState) {
        pluginState = state
    }/

    override fun enableSmoothTransition(): Boolean {
        return enableSmoothTransition
    }

    override fun setEnableSmoothTransition(enableSmoothTransition: Boolean) {
        this.enableSmoothTransition = enableSmoothTransition
    }

    override fun getAllowContentAccess(): Boolean {
        return allowContentAccess
    }

    override fun setAllowContentAccess(allow: Boolean) {
        allowContentAccess = allow
    }

    override fun getDisplayZoomControls(): Boolean {
        return displayZoomControls
    }

    override fun setDisplayZoomControls(enabled: Boolean) {
        displayZoomControls = enabled
    }

    override fun getTextZoom(): Int {
        return textZoom
    }

    override fun setTextZoom(textZoom: Int) {
        this.textZoom = textZoom
    }

    override fun getAllowFileAccessFromFileURLs(): Boolean {
        return allowFileAccessFromFile
    }

    override fun setAllowFileAccessFromFileURLs(allow: Boolean) {
        allowFileAccessFromFile = allow
    }

    override fun getAllowUniversalAccessFromFileURLs(): Boolean {
        return allowUniversalAccessFromFile
    }

    override fun setAllowUniversalAccessFromFileURLs(allow: Boolean) {
        allowUniversalAccessFromFile = allow
    }

    override fun getMediaPlaybackRequiresUserGesture(): Boolean {
        return mediaPlaybackRequiresUserGesture
    }

    override fun setMediaPlaybackRequiresUserGesture(require: Boolean) {
        mediaPlaybackRequiresUserGesture = require
    }

    override fun getMixedContentMode(): Int {
        return mixedContentMode
    }

    override fun setMixedContentMode(mixedContentMode: Int) {
        this.mixedContentMode = mixedContentMode
    }

    override fun getOffscreenPreRaster(): Boolean {
        return false
    }

    override fun setOffscreenPreRaster(enabled: Boolean) {
    }

    override fun getDisabledActionModeMenuItems(): Int {
        return 0
    }

    override fun setDisabledActionModeMenuItems(menuItems: Int) {
    }

    override fun getSafeBrowsingEnabled(): Boolean {
        return false
    }

    override fun setSafeBrowsingEnabled(enabled: Boolean) {
    }
}