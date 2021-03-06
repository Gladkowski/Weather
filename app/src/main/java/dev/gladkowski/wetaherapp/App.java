package dev.gladkowski.wetaherapp;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.mapbox.mapboxsdk.Mapbox;

import net.danlew.android.joda.JodaTimeAndroid;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dev.gladkowski.wetaherapp.di.app.component.DaggerAppComponent;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        DaggerAppComponent
                .builder()
                .create(this)
                .inject(this);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        Mapbox.getInstance(this, (BuildConfig.MapBoxAccessToken));
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

}
