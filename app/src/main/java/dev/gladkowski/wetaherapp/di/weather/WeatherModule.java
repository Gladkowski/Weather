package dev.gladkowski.wetaherapp.di.weather;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dev.gladkowski.wetaherapp.di.base.modules.BaseFragmentModule;
import dev.gladkowski.wetaherapp.presentation.weather.WeatherFragment;


@Module(includes = {BaseFragmentModule.class, WeatherPresenterModule.class,
        WeatherRepositoryModule.class, WeatherUtilsModule.class})
public interface WeatherModule {

    @Binds
    Fragment bindFragment(WeatherFragment weatherFragment);
}
