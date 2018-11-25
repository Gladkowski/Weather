package dev.gladkowski.wetaherapp.data.repository.weather;

import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.Single;

/**
 * Repository for Weather
 */
public interface WeatherRepository {

    /**
     * Get weather by coordinates
     */
    Single<Weather> getLocalWeather();
}
