package dev.gladkowski.wetaherapp.data.repository.weather;

import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.Single;

/**
 * Implementation of WeatherRepository
 */
public class WeatherRepositoryImpl implements WeatherRepository {

    private WeatherApi weatherApi;
    private WeatherByCoordinatesResponseConverter converter;

    public WeatherRepositoryImpl(WeatherApi weatherApi,
                                 WeatherByCoordinatesResponseConverter converter) {
        this.weatherApi = weatherApi;
        this.converter = converter;
    }


    @Override
    public Single<Weather> getWeatherByCoordinates(float lat, float lon) {
        return weatherApi.getWeatherBycoordinates(lat, lon)
                .map(converter);
    }
}
