package dev.gladkowski.wetaherapp.di.weather;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverterImpl;

@Module
public interface WeatherUtilsModule {

    @Provides
    static WeatherByCoordinatesResponseConverter provideWeatherByCoordinatesResponseConverter() {
        return new WeatherByCoordinatesResponseConverterImpl();
    }
}
