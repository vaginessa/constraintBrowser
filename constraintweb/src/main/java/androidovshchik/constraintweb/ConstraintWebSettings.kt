package androidovshchik.constraintweb

import android.webkit.WebSettings
import java.lang.ref.WeakReference

/**
 * All parameters [android.webkit.WebView] in callback methods will be null
 */
open class ConstraintWebSettings(view: ConstraintWebView) : WebSettings() {

    protected val webLayout = WeakReference(view)

    override fun getBlockNetworkImage(): Boolean {
        return false
    }

    override fun setBlockNetworkImage(flag: Boolean) {}
    
    override fun getJavaScriptEnabled(): Boolean {
        return false
    }

    override fun setJavaScriptEnabled(flag: Boolean) {}

    override fun getLightTouchEnabled(): Boolean {
        return false
    }

    override fun setLightTouchEnabled(flag: Boolean) {}

    override fun setNeedInitialFocus(flag: Boolean) {}

    override fun setRenderPriority(priority: RenderPriority) {}

    override fun setSupportMultipleWindows(support: Boolean) {}

    override fun setSupportZoom(support: Boolean) {}

    override fun getCacheMode(): Int {
        return LOAD_DEFAULT
    }

    override fun setCacheMode(mode: Int) {}

    override fun getUseWideViewPort(): Boolean {
        return false
    }

    override fun setUseWideViewPort(useWideViewPort: Boolean) {}

    override fun getSaveFormData(): Boolean {
        return false
    }

    override fun setSaveFormData(saveFormData: Boolean) {}

    override fun getJavaScriptCanOpenWindowsAutomatically(): Boolean {
        return false
    }

    override fun setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowAutomatically: Boolean) {}

    override fun setLayoutAlgorithm(algorithm: LayoutAlgorithm) {}

    override fun getDefaultTextEncodingName(): String {
        return defaultTextEncoding
    }

    override fun setDefaultTextEncodingName(defaultTextEncoding: String) {}

    override fun getDefaultFontSize(): Int {
        return defaultFontSize
    }

    override fun setDefaultFontSize(defaultFontSize: Int) {}

    override fun getLoadsImagesAutomatically(): Boolean {
        return loadsImagesAutomatically
    }

    override fun setLoadsImagesAutomatically(loadsImagesAutomatically: Boolean) {}

    override fun getDefaultFixedFontSize(): Int {
        return defaultFixedFontSize
    }

    override fun setDefaultFixedFontSize(defaultFixedFontSize: Int) {}

    override fun getMinimumLogicalFontSize(): Int {
        return minimumLogicalFontSize
    }

    override fun setMinimumLogicalFontSize(minimumLogicalFontSize: Int) {}

    override fun getMinimumFontSize(): Int {
        return minimumFontSize
    }

    override fun setMinimumFontSize(minimumFontSize: Int) {}

    override fun getFantasyFontFamily(): String {
        return fantasyFontFamily
    }

    override fun setFantasyFontFamily(fantasyFontFamily: String) {}

    override fun getCursiveFontFamily(): String {
        return cursiveFontFamily
    }

    override fun setCursiveFontFamily(cursiveFontFamily: String) {}

    override fun getSerifFontFamily(): String {
        return serifFontFamily
    }

    override fun setSerifFontFamily(serifFontFamily: String) {}

    override fun getSansSerifFontFamily(): String {
        return sansSerifFontFamily
    }

    override fun setSansSerifFontFamily(sansSerifFontFamily: String) {}

    override fun getFixedFontFamily(): String {
        return fixedFontFamily
    }

    override fun setFixedFontFamily(fixedFontFamily: String) {}

    override fun getStandardFontFamily(): String {
        return standardFontFamily
    }

    override fun setStandardFontFamily(standardFontFamily: String) {}

    override fun getLayoutAlgorithm(): LayoutAlgorithm {
        return layoutAlgorithm
    }

    override fun supportMultipleWindows(): Boolean {
        return supportMultipleWindows
    }

    override fun getSavePassword(): Boolean {
        return savePassword
    }

    override fun setSavePassword(savePassword: Boolean) {}

    override fun supportZoom(): Boolean {
        return supportZoom
    }

    override fun getAllowFileAccess(): Boolean {
        return allowFileAccess
    }

    override fun setAllowFileAccess(allow: Boolean) {}

    override fun getBuiltInZoomControls(): Boolean {
        return builtInZoomControls
    }

    override fun setBuiltInZoomControls(enabled: Boolean) {}
    
    override fun getUserAgentString(): String? {
        return userAgentString
    }

    override fun setUserAgentString(ua: String?) {}
    
    override fun getDatabaseEnabled(): Boolean {
        return databaseEnabled
    }

    override fun setDatabaseEnabled(flag: Boolean) {}

    override fun getDatabasePath(): String {
        return databasePath
    }

    override fun setDatabasePath(path: String) {}

    override fun setGeolocationDatabasePath(geolocationDatabasePath: String) {}

    override fun setGeolocationEnabled(geolocationEnabled: Boolean) {}
    
    override fun getDefaultZoom(): ZoomDensity? {
        return defaultZoom
    }

    override fun setDefaultZoom(zoom: ZoomDensity) {}
    
    override fun getDomStorageEnabled(): Boolean {
        return domStorageEnabled
    }

    override fun setDomStorageEnabled(flag: Boolean) {}

    override fun getLoadWithOverviewMode(): Boolean {
        return loadWithOverviewMode
    }

    override fun setLoadWithOverviewMode(flag: Boolean) {}

    override fun setAppCacheEnabled(appCacheEnabled: Boolean) {}

    override fun setAppCacheMaxSize(appCacheMaxSize: Long) {}

    override fun setAppCachePath(appCachePath: String) {}

    override fun getBlockNetworkLoads(): Boolean {
        return blockNetworkLoads
    }

    override fun setBlockNetworkLoads(flag: Boolean) {}

    override fun getPluginState(): PluginState {
        return pluginState
    }

    override fun setPluginState(state: PluginState) {}

    override fun enableSmoothTransition(): Boolean {
        return enableSmoothTransition
    }

    override fun setEnableSmoothTransition(enableSmoothTransition: Boolean) {
        this.enableSmoothTransition = enableSmoothTransition
    }

    override fun getAllowContentAccess(): Boolean {
        return allowContentAccess
    }

    override fun setAllowContentAccess(allow: Boolean) {}

    override fun getDisplayZoomControls(): Boolean {
        return displayZoomControls
    }

    override fun setDisplayZoomControls(enabled: Boolean) {}

    override fun getTextZoom(): Int {
        return textZoom
    }

    override fun setTextZoom(textZoom: Int) {}

    override fun getAllowFileAccessFromFileURLs(): Boolean {
        return allowFileAccessFromFile
    }

    override fun setAllowFileAccessFromFileURLs(allow: Boolean) {}

    override fun getAllowUniversalAccessFromFileURLs(): Boolean {
        return allowUniversalAccessFromFile
    }

    override fun setAllowUniversalAccessFromFileURLs(allow: Boolean) {}

    override fun getMediaPlaybackRequiresUserGesture(): Boolean {
        return mediaPlaybackRequiresUserGesture
    }

    override fun setMediaPlaybackRequiresUserGesture(require: Boolean) {}

    override fun getMixedContentMode(): Int {
        return mixedContentMode
    }

    override fun setMixedContentMode(mixedContentMode: Int) {}

    override fun getOffscreenPreRaster(): Boolean {
        return false
    }

    override fun setOffscreenPreRaster(enabled: Boolean) {}

    override fun getDisabledActionModeMenuItems(): Int {
        return 0
    }

    override fun setDisabledActionModeMenuItems(menuItems: Int) {}

    override fun getSafeBrowsingEnabled(): Boolean {
        return false
    }

    override fun setSafeBrowsingEnabled(enabled: Boolean) {}
}