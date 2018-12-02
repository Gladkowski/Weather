package dev.gladkowski.wetaherapp.data.repository.weather;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
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

    /**
     * Get forecast by coordinates
     */
    Single<List<Forecast>> getLocalForecast();
}
