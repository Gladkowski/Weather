package dev.gladkowski.wetaherapp.di.weather;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepositoryImpl;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;

@Module
public interface WeatherRepositoryModule {

    @Provides
    static WeatherRepository provideWeatherRepository(WeatherApi weatherApi,
                                                      WeatherByCoordinatesResponseConverter converter) {
        return new WeatherRepositoryImpl(weatherApi, converter);
    }
}
