package dev.gladkowski.wetaherapp.di.permission;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.presentation.permission.PermissionPresenter;
import dev.gladkowski.wetaherapp.presentation.permission.provider.PermissionResourceProvider;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

@Module
public interface PermissionPresenterModule {

    @Provides
    static PermissionPresenter providePermissionPresenter(Router router,
                                                          ErrorResourceProvider errorResourceProvider,
                                                          PermissionResourceProvider resourceProvider) {
        return new PermissionPresenter(router, errorResourceProvider, resourceProvider);
    }
}
