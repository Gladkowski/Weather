package dev.gladkowski.wetaherapp.di.weather;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.presentation.weather.WeatherPresenter;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

@Module
public interface WeatherPresenterModule {

    @Provides
    static WeatherPresenter provideWeatherPresenter(Router router,
                                                    ErrorResourceProvider errorResourceProvider,
                                                    WeatherInteractor weatherInteractor) {
        return new WeatherPresenter(router, errorResourceProvider, weatherInteractor);
    }
}
