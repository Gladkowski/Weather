package dev.gladkowski.wetaherapp.di.weather;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.ForecastByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.ForecastByCoordinatesResponseConverterImpl;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverterImpl;
import dev.gladkowski.wetaherapp.presentation.weather.converter.ForecastItemConverter;
import dev.gladkowski.wetaherapp.presentation.weather.converter.ForecastItemConverterImpl;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherImageConverter;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherImageConverterImpl;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherViewModelConverter;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherViewModelConverterImpl;
import dev.gladkowski.wetaherapp.presentation.weather.provider.WeatherResourceProvider;
import dev.gladkowski.wetaherapp.presentation.weather.provider.WeatherResourceProviderImpl;
import dev.gladkowski.wetaherapp.utils.location.LocationProvider;
import dev.gladkowski.wetaherapp.utils.location.SmartLocationProviderImpl;

@Module
public interface WeatherUtilsModule {

    @Provides
    static WeatherByCoordinatesResponseConverter provideWeatherByCoordinatesResponseConverter() {
        return new WeatherByCoordinatesResponseConverterImpl();
    }

    @Provides
    static ForecastByCoordinatesResponseConverter provideForecastByCoordinatesResponseConverter() {
        return new ForecastByCoordinatesResponseConverterImpl();
    }

    /**
     * SmartLocation implementation of LocationProvider
     */
    @Provides
    static LocationProvider provideLocationProvider(Context context) {
        return new SmartLocationProviderImpl(context);
    }

    /**
     * Android implementation of LocationProvider
     */
//    @Provides
//    static LocationProvider provideAndroidLocationProviderImpl(Context context) {
//        return new AndroidLocationProviderImpl(context);
//    }

    @Provides
    static WeatherResourceProvider provideWeatherResourceProvider(Context context) {
        return new WeatherResourceProviderImpl(context);
    }

    @Provides
    static WeatherViewModelConverter provideWeatherViewModelConverter(WeatherResourceProvider resourceProvider) {
        return new WeatherViewModelConverterImpl(resourceProvider);
    }

    @Provides
    static ForecastItemConverter provideForecastItemConverter(WeatherResourceProvider resourceProvider) {
        return new ForecastItemConverterImpl(resourceProvider);
    }

    @Provides
    static WeatherImageConverter provideWeatherImageConverter() {
        return new WeatherImageConverterImpl();
    }
}
