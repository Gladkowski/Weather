package dev.gladkowski.wetaherapp.di.main.module;


import android.support.v4.app.FragmentManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.di.base.modules.BaseActivityModule;
import dev.gladkowski.wetaherapp.di.base.scopes.ActivityScope;
import dev.gladkowski.wetaherapp.presentation.main.MainPresenter;
import ru.terrakok.cicerone.Router;

@Module
public interface MainPresenterModule {

    @Provides
    @ActivityScope
    static MainPresenter provideMainPresenter(Router router,
                                              @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
                                                      FragmentManager fragmentManager) {
        return new MainPresenter(router, fragmentManager);
    }
}
