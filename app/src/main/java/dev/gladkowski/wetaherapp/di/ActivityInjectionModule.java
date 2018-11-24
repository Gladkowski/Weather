package dev.gladkowski.wetaherapp.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.gladkowski.wetaherapp.di.base.scopes.ActivityScope;
import dev.gladkowski.wetaherapp.di.main.module.MainModule;
import dev.gladkowski.wetaherapp.presentation.main.MainActivity;


@Module
public interface ActivityInjectionModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    MainActivity mainActivityInjector();

}
