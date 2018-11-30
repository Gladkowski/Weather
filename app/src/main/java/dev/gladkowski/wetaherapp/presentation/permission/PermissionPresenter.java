package dev.gladkowski.wetaherapp.presentation.permission;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.wetaherapp.presentation.common.constants.MainScreens;
import dev.gladkowski.wetaherapp.presentation.permission.provider.PermissionResourceProvider;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for PermissionFragment
 */
@InjectViewState
public class PermissionPresenter extends BaseNetworkPresenter<PermissionView> {

    @NonNull
    private Router router;
    @NonNull
    private ErrorResourceProvider errorResourceProvider;
    @NonNull
    private PermissionResourceProvider resourceProvider;

    public PermissionPresenter(@NonNull Router router,
                               @NonNull ErrorResourceProvider errorResourceProvider,
                               @NonNull PermissionResourceProvider resourceProvider) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.resourceProvider = resourceProvider;
    }

    @NonNull
    @Override
    public Router getRouter() {
        return router;
    }

    @NonNull
    @Override
    public ErrorResourceProvider getErrorResourceProvider() {
        return errorResourceProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void initData() {
        getViewState().onSetTitle(resourceProvider.getTitle());
        getViewState().checkPermissions();
    }

    void onPermissionsGranted() {
        getViewState().hidePermissionNeededView();
        navigateToWeatherFragment();
    }

    void onPermissionDenied() {
        getViewState().showPermissionNeededView();
    }

    ///////////////////////////////////////////////////////////////////////////
    // NAVIGATION
    ///////////////////////////////////////////////////////////////////////////

    private void navigateToWeatherFragment() {
//        getRouter().newScreenChain(MainScreens.WEATHER_PAGE);
        getRouter().newRootScreen(MainScreens.WEATHER_PAGE);
    }
}
