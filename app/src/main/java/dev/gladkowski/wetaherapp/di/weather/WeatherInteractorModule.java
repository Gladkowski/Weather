package dev.gladkowski.wetaherapp.di.weather;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractorImpl;
import dev.gladkowski.wetaherapp.utils.rx.RxUtils;
import dev.gladkowski.wetaherapp.utils.rx.SingleErrorHandler;

@Module
public interface WeatherInteractorModule {

    @Provides
    static WeatherInteractor provideWeatherInteractor(WeatherRepository weatherRepository,
                                                      SingleErrorHandler singleErrorHandler,
                                                      RxUtils rxUtils) {
        return new WeatherInteractorImpl(weatherRepository, singleErrorHandler, rxUtils);
    }
}
