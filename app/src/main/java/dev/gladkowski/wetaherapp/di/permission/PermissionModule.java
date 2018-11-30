package dev.gladkowski.wetaherapp.di.permission;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dev.gladkowski.wetaherapp.presentation.permission.PermissionFragment;

@Module(includes = {PermissionPresenterModule.class, PermissionUtilsModule.class})
public interface PermissionModule {

    @Binds
    Fragment bindFragment(PermissionFragment permissionFragment);
}
