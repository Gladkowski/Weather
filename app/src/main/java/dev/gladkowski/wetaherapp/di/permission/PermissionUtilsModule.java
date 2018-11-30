package dev.gladkowski.wetaherapp.di.permission;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.presentation.permission.provider.PermissionResourceProvider;
import dev.gladkowski.wetaherapp.presentation.permission.provider.PermissionResourceProviderImpl;

@Module
public interface PermissionUtilsModule {

    @Provides
    static PermissionResourceProvider providePermissionResourceProvider(Context context) {
        return new PermissionResourceProviderImpl(context);
    }
}
