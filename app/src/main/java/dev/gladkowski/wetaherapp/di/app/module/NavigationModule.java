package dev.gladkowski.wetaherapp.di.app.module;

import android.support.v4.app.FragmentManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.di.base.modules.BaseActivityModule;
import dev.gladkowski.wetaherapp.utils.navigation.main.MainNavigator;
import dev.gladkowski.wetaherapp.utils.navigation.main.MainNavigatorImpl;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public interface NavigationModule {

    @Provides
    @Singleton
    static Router provideRouter(Cicerone<Router> cicerone) {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    static NavigatorHolder provideNavigatorHolder(Cicerone<Router> cicerone) {
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    static Cicerone<Router> provideCicerone() {
        return Cicerone.create();
    }


    @Provides
    @Singleton
    static MainNavigator provideMainNavigator(@Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
                                                      FragmentManager fragmentManager) {
        return new MainNavigatorImpl(fragmentManager);
    }
}
