package dev.gladkowski.wetaherapp.di.app.module.network;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.BuildConfig;
import dev.gladkowski.wetaherapp.entity.app.data.AppConfig;
import dev.gladkowski.wetaherapp.utils.network.ApiKeyInterceptor;
import dev.gladkowski.wetaherapp.utils.network.UnitsInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public interface CommonNetworkModule {

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                            ApiKeyInterceptor apiKeyInterceptor,
                                            UnitsInterceptor unitsInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(unitsInterceptor)
                .connectTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit.Builder provideRetrofitBuilder(Converter.Factory converterFactory, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(converterFactory);
    }

    @Provides
    static Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.baseUrl(BuildConfig.OwmBaseUrl).build();
    }

    @Provides
    @Singleton
    static ApiKeyInterceptor provideApiKeyInterceptor() {
        return new ApiKeyInterceptor();
    }

    @Provides
    @Singleton
    static UnitsInterceptor provideUnitsInterceptor() {
        return new UnitsInterceptor();
    }
}
