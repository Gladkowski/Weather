package dev.gladkowski.wetaherapp.presentation.weather;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherViewModelConverter;
import dev.gladkowski.wetaherapp.presentation.weather.provider.WeatherResourceProvider;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import io.reactivex.disposables.Disposable;
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
    @NonNull
    private WeatherResourceProvider resourceProvider;
    @NonNull
    private WeatherViewModelConverter weatherConverter;

    public WeatherPresenter(@NonNull Router router,
                            @NonNull ErrorResourceProvider errorResourceProvider,
                            @NonNull WeatherInteractor weatherInteractor,
                            @NonNull WeatherResourceProvider resourceProvider,
                            @NonNull WeatherViewModelConverter weatherConverter) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.weatherInteractor = weatherInteractor;
        this.resourceProvider = resourceProvider;
        this.weatherConverter = weatherConverter;
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
        getWeather();
    }

    private void getWeather() {
        getViewState().onShowLoading();

        Disposable subscription = weatherInteractor.getLocalWeather()
                .map(weatherConverter)
                .subscribe(weatherViewModel -> {
                    getViewState().showCurrentWeatherData(weatherViewModel);
                    getViewState().onHideLoading();
                }, exception -> {
                    processErrors(exception);
                    getViewState().onHideLoading();
                });

        unsubscribeOnDestroy(subscription);
    }
}
