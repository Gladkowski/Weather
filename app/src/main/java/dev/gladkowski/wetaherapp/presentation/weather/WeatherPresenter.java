package dev.gladkowski.wetaherapp.presentation.weather;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.wetaherapp.presentation.weather.converter.ForecastItemConverter;
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
    @NonNull
    private ForecastItemConverter forecastConverter;

    public WeatherPresenter(@NonNull Router router,
                            @NonNull ErrorResourceProvider errorResourceProvider,
                            @NonNull WeatherInteractor weatherInteractor,
                            @NonNull WeatherResourceProvider resourceProvider,
                            @NonNull WeatherViewModelConverter weatherConverter,
                            @NonNull ForecastItemConverter forecastConverter) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.weatherInteractor = weatherInteractor;
        this.resourceProvider = resourceProvider;
        this.weatherConverter = weatherConverter;
        this.forecastConverter = forecastConverter;
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
                    getForecast();
                    getViewState().onHideLoading();
                }, exception -> {
                    processErrors(exception);
                    getViewState().onHideLoading();
                });

        unsubscribeOnDestroy(subscription);
    }

    private void getForecast() {
        Disposable subscription = weatherInteractor.getLocalForecast()
                .map(forecastConverter)
                .subscribe(forecast -> getViewState().showList(forecast), this::processErrors);

        unsubscribeOnDestroy(subscription);
    }

    void refresh() {
        getViewState().onShowRefreshLoading();

        Disposable subscription = weatherInteractor.getLocalWeather()
                .map(weatherConverter)
                .subscribe(weatherViewModel -> {
                    getViewState().showCurrentWeatherData(weatherViewModel);
                    getViewState().onHideRefreshLoading();
                }, exception -> {
                    processErrors(exception);
                    getViewState().onHideRefreshLoading();
                });

        unsubscribeOnDestroy(subscription);
    }
}
