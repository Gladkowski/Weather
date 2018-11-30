package dev.gladkowski.wetaherapp.di.app.module;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.di.base.scopes.ActivityScope;
import dev.gladkowski.wetaherapp.presentation.main.MainPresenter;
import ru.terrakok.cicerone.Router;

@Module
public interface MainPresenterModule {

    @Provides
    @ActivityScope
    static MainPresenter bindMainPresenter(Router router, FragmentManager fragmentManager) {
        return new MainPresenter(router, fragmentManager);
    }
}
