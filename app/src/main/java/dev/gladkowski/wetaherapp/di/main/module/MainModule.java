package dev.gladkowski.wetaherapp.di.main.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.gladkowski.wetaherapp.di.base.modules.BaseActivityModule;
import dev.gladkowski.wetaherapp.di.base.modules.BaseFragmentModule;
import dev.gladkowski.wetaherapp.di.base.scopes.ActivityScope;
import dev.gladkowski.wetaherapp.di.permission.PermissionModule;
import dev.gladkowski.wetaherapp.di.permission.PermissionScope;
import dev.gladkowski.wetaherapp.di.weather.WeatherModule;
import dev.gladkowski.wetaherapp.di.weather.WeatherScope;
import dev.gladkowski.wetaherapp.presentation.main.MainActivity;
import dev.gladkowski.wetaherapp.presentation.permission.PermissionFragment;
import dev.gladkowski.wetaherapp.presentation.weather.WeatherFragment;


@Module(includes = {BaseActivityModule.class, MainPresenterModule.class, BaseFragmentModule.class,
        WeatherModule.class, PermissionModule.class})
public interface MainModule {

    @Binds
    @ActivityScope
    AppCompatActivity bindAppCompatActivity(MainActivity mainActivity);

    @PermissionScope
    @ContributesAndroidInjector(modules = PermissionModule.class)
    PermissionFragment permissionFragmentInjector();

    @WeatherScope
    @ContributesAndroidInjector(modules = WeatherModule.class)
    WeatherFragment weatherFragmentInjector();
}
