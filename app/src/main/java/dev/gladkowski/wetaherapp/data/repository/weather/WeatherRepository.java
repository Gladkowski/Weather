package dev.gladkowski.wetaherapp.data.repository.weather;

import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.Single;

/**
 * Repository for Weather
 */
public interface WeatherRepository {

    /**
     * Get weather by coordinates
     *
     * @param lat latitude
     * @param lon longitude
     */
    Single<Weather> getWeatherBycoordinates(float lat, float lon);
}
