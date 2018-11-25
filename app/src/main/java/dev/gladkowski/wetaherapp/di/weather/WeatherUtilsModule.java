package dev.gladkowski.wetaherapp.di.weather;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverterImpl;
import dev.gladkowski.wetaherapp.utils.location.LocationProvider;
import dev.gladkowski.wetaherapp.utils.location.LocationProviderImpl;

@Module
public interface WeatherUtilsModule {

    @Provides
    static WeatherByCoordinatesResponseConverter provideWeatherByCoordinatesResponseConverter() {
        return new WeatherByCoordinatesResponseConverterImpl();
    }

    @Provides
    static LocationProvider providLocationProvider(Context context) {
        return new LocationProviderImpl(context);
    }
}
