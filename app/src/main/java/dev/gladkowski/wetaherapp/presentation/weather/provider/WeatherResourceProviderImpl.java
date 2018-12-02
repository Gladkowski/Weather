package dev.gladkowski.wetaherapp.presentation.weather.provider;

import android.content.Context;

import dev.gladkowski.wetaherapp.R;

/**
 * Implementation of WeatherResourceProvider
 */
public class WeatherResourceProviderImpl implements WeatherResourceProvider {

    private Context context;

    public WeatherResourceProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getTitle() {
        return context.getString(R.string.app_name);
    }

    @Override
    public String getCelcius() {
        return context.getString(R.string.weather_celsius);
    }
}
