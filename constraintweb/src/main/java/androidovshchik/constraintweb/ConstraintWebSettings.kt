package androidovshchik.constraintweb

import android.webkit.WebSettings
import java.lang.ref.WeakReference

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
        return "UTF-8"
    }

    override fun setDefaultTextEncodingName(defaultTextEncoding: String) {}

    override fun getDefaultFontSize(): Int {
        return 16
    }

    override fun setDefaultFontSize(defaultFontSize: Int) {}

    override fun getLoadsImagesAutomatically(): Boolean {
        return false
    }

    override fun setLoadsImagesAutomatically(loadsImagesAutomatically: Boolean) {}

    override fun getDefaultFixedFontSize(): Int {
        return 0
    }

    override fun setDefaultFixedFontSize(defaultFixedFontSize: Int) {}

    override fun getMinimumLogicalFontSize(): Int {
        return 0
    }

    override fun setMinimumLogicalFontSize(minimumLogicalFontSize: Int) {}

    override fun getMinimumFontSize(): Int {
        return 0
    }

    override fun setMinimumFontSize(minimumFontSize: Int) {}

    override fun getFantasyFontFamily(): String? {
        return null
    }

    override fun setFantasyFontFamily(fantasyFontFamily: String) {}

    override fun getCursiveFontFamily(): String? {
        return null
    }

    override fun setCursiveFontFamily(cursiveFontFamily: String) {}

    override fun getSerifFontFamily(): String? {
        return null
    }

    override fun setSerifFontFamily(serifFontFamily: String) {}

    override fun getSansSerifFontFamily(): String? {
        return null
    }

    override fun setSansSerifFontFamily(sansSerifFontFamily: String) {}

    override fun getFixedFontFamily(): String? {
        return null
    }

    override fun setFixedFontFamily(fixedFontFamily: String) {}

    override fun getStandardFontFamily(): String? {
        return null
    }

    override fun setStandardFontFamily(standardFontFamily: String) {}

    override fun getLayoutAlgorithm(): LayoutAlgorithm {
        return LayoutAlgorithm.NORMAL
    }

    override fun supportMultipleWindows(): Boolean {
        return false
    }

    override fun getSavePassword(): Boolean {
        return false
    }

    override fun setSavePassword(savePassword: Boolean) {}

    override fun supportZoom(): Boolean {
        return false
    }

    override fun getAllowFileAccess(): Boolean {
        return false
    }

    override fun setAllowFileAccess(allow: Boolean) {}

    override fun getBuiltInZoomControls(): Boolean {
        return false
    }

    override fun setBuiltInZoomControls(enabled: Boolean) {}
    
    override fun getUserAgentString(): String? {
        return "Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"
    }

    override fun setUserAgentString(ua: String?) {}
    
    override fun getDatabaseEnabled(): Boolean {
        return false
    }

    override fun setDatabaseEnabled(flag: Boolean) {}

    override fun getDatabasePath(): String {
        return "database"
    }

    override fun setDatabasePath(path: String) {}

    override fun setGeolocationDatabasePath(geolocationDatabasePath: String) {}

    override fun setGeolocationEnabled(geolocationEnabled: Boolean) {}
    
    override fun getDefaultZoom(): ZoomDensity? {
        return null
    }

    override fun setDefaultZoom(zoom: ZoomDensity) {}
    
    override fun getDomStorageEnabled(): Boolean {
        return false
    }

    override fun setDomStorageEnabled(flag: Boolean) {}

    override fun getLoadWithOverviewMode(): Boolean {
        return false
    }

    override fun setLoadWithOverviewMode(flag: Boolean) {}

    override fun setAppCacheEnabled(appCacheEnabled: Boolean) {}

    override fun setAppCacheMaxSize(appCacheMaxSize: Long) {}

    override fun setAppCachePath(appCachePath: String) {}

    override fun getBlockNetworkLoads(): Boolean {
        return false
    }

    override fun setBlockNetworkLoads(flag: Boolean) {}

    override fun getPluginState(): PluginState {
        return PluginState.OFF
    }

    override fun setPluginState(state: PluginState) {}

    override fun enableSmoothTransition(): Boolean {
        return false
    }

    override fun setEnableSmoothTransition(enableSmoothTransition: Boolean) {}

    override fun getAllowContentAccess(): Boolean {
        return false
    }

    override fun setAllowContentAccess(allow: Boolean) {}

    override fun getDisplayZoomControls(): Boolean {
        return false
    }

    override fun setDisplayZoomControls(enabled: Boolean) {}

    override fun getTextZoom(): Int {
        return 100
    }

    override fun setTextZoom(textZoom: Int) {}

    override fun getAllowFileAccessFromFileURLs(): Boolean {
        return false
    }

    override fun setAllowFileAccessFromFileURLs(allow: Boolean) {}

    override fun getAllowUniversalAccessFromFileURLs(): Boolean {
        return false
    }

    override fun setAllowUniversalAccessFromFileURLs(allow: Boolean) {}

    override fun getMediaPlaybackRequiresUserGesture(): Boolean {
        return false
    }

    override fun setMediaPlaybackRequiresUserGesture(require: Boolean) {}

    override fun getMixedContentMode(): Int {
        return 0
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