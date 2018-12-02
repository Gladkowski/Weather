package dev.gladkowski.wetaherapp.domain.weather;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.Single;

/**
 * Interactor for weather
 */
public interface WeatherInteractor {

    /**
     * Get weather by coordinates
     */
    Single<Weather> getLocalWeather();

    /**
     * Get forecast by coordinates
     */
    Single<List<Forecast>> getLocalForecast();

}
