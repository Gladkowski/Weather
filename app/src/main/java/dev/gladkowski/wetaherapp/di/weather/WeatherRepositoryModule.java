package dev.gladkowski.wetaherapp.di.weather;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepositoryImpl;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.ForecastByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.utils.location.LocationProvider;

@Module
public interface WeatherRepositoryModule {

    @Provides
    static WeatherRepository provideWeatherRepository(WeatherApi weatherApi,
                                                      WeatherByCoordinatesResponseConverter converter,
                                                      ForecastByCoordinatesResponseConverter forecastConverter,
                                                      LocationProvider locationProvider) {
        return new WeatherRepositoryImpl(weatherApi, converter, forecastConverter,
                locationProvider);
    }
}
