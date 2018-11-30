package dev.gladkowski.wetaherapp.di.base.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dev.gladkowski.wetaherapp.di.base.scopes.ActivityScope;
import dev.gladkowski.wetaherapp.di.main.qualifier.ActivityContext;


@Module
public interface BaseActivityModule {

    @Binds
    Activity activity(AppCompatActivity appCompatActivity);

    @Binds
    @ActivityScope
    @ActivityContext
    Context bindContext(Activity activity);
}
