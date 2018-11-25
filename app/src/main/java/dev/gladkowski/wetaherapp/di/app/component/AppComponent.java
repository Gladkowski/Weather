package dev.gladkowski.wetaherapp.di.app.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dev.gladkowski.wetaherapp.App;
import dev.gladkowski.wetaherapp.di.ActivityInjectionModule;
import dev.gladkowski.wetaherapp.di.app.module.AppModule;
import dev.gladkowski.wetaherapp.di.app.module.NavigationModule;
import dev.gladkowski.wetaherapp.di.app.module.UtilModule;
import dev.gladkowski.wetaherapp.di.app.module.network.ApiModule;


@Singleton
@Component(modules = {AppModule.class, ActivityInjectionModule.class, NavigationModule.class,
        UtilModule.class, ApiModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
