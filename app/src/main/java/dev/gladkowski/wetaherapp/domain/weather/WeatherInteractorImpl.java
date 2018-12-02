package dev.gladkowski.wetaherapp.domain.weather;

import java.util.List;

import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.utils.rx.RxUtils;
import dev.gladkowski.wetaherapp.utils.rx.SingleErrorHandler;
import io.reactivex.Single;

/**
 * Implementation of WeatherInteractor
 */
public class WeatherInteractorImpl implements WeatherInteractor {

    private WeatherRepository weatherRepository;
    private SingleErrorHandler singleErrorHandler;
    private RxUtils rxUtils;

    public WeatherInteractorImpl(WeatherRepository weatherRepository,
                                 SingleErrorHandler singleErrorHandler,
                                 RxUtils rxUtils) {
        this.weatherRepository = weatherRepository;
        this.singleErrorHandler = singleErrorHandler;
        this.rxUtils = rxUtils;
    }

    @Override
    public Single<Weather> getLocalWeather() {
        return weatherRepository.getLocalWeather()
                .compose((SingleErrorHandler<Weather>) singleErrorHandler)
                .compose(rxUtils.applySingleSchedulers());
    }

    @Override
    public Single<List<Forecast>> getLocalForecast() {
        return weatherRepository.getLocalForecast()
                .compose((SingleErrorHandler<List<Forecast>>) singleErrorHandler)
                .compose(rxUtils.applySingleSchedulers());
    }
}
