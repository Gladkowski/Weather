package dev.gladkowski.wetaherapp.domain.weather;

import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.Single;

/**
 * Interactor for weather
 */
public interface WeatherInteractor {

    /**
     * Get weather by coordinates
     *
     * @param lat latitude
     * @param lon longitude
     */
    Single<Weather> getWeatherByCoordinates(float lat, float lon);
}
