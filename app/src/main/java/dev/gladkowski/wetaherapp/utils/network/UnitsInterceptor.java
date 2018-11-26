package dev.gladkowski.wetaherapp.utils.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor that adds units query parameter
 */
public class UnitsInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        HttpUrl url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("units", "metric")
                .build();

        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
