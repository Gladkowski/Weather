package dev.gladkowski.wetaherapp.di.app.module.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class, CommonNetworkModule.class})
public interface ApiModule {

    @Singleton
    @Provides
    static WeatherApi provideMoviesApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }
}
