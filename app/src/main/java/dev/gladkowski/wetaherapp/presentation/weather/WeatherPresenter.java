package dev.gladkowski.wetaherapp.presentation.weather;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for WeatherFragment
 */
@InjectViewState
public class WeatherPresenter extends BaseNetworkPresenter<WeatherView> {

    @NonNull
    private Router router;
    @NonNull
    private ErrorResourceProvider errorResourceProvider;
    @NonNull
    private WeatherInteractor weatherInteractor;

    public WeatherPresenter(@NonNull Router router,
                            @NonNull ErrorResourceProvider errorResourceProvider,
                            @NonNull WeatherInteractor weatherInteractor) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.weatherInteractor = weatherInteractor;
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
        getViewState().checkPermissions();
        getWeather();
    }

    private void getWeather() {
//        getViewState().onShowLoading();
//
//        Disposable subscription = weatherInteractor.getWeatherByCoordinates(50f, 14.44f)
//                .subscribe(movieItem -> {
//                    getViewState().onHideLoading();
//
//                }, exception -> {
//                    processErrors(exception);
//                    getViewState().onHideLoading();
//                });
//
//        unsubscribeOnDestroy(subscription);
    }

    public void onPermissionsGranted() {
        Log.v("PERMISSION_TEST", "GRANTED");
        getViewState().hidePermissionNeededView();
        getViewState().showWeatherViews();
    }

    public void onPermissionDenied() {
        Log.v("PERMISSION_TEST", "DENIED");
        getViewState().showPermissionNeededView();
        getViewState().hideWeatherViews();
    }
}
