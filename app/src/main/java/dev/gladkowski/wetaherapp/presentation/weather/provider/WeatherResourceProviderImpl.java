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
    public String getCelsius() {
        return context.getString(R.string.weather_celsius);
    }

    @Override
    public String getPercents() {
        return context.getString(R.string.weather_percents);
    }

    @Override
    public String getMeters() {
        return context.getString(R.string.weather_meters);
    }

    @Override
    public String getMetersPerSecond() {
        return context.getString(R.string.weather_meters_per_second);
    }

    @Override
    public String getHumidity() {
        return context.getString(R.string.weather_humidity);
    }

    @Override
    public String getPressure() {
        return context.getString(R.string.weather_pressure);
    }

    @Override
    public String getWindSpeed() {
        return context.getString(R.string.weather_wind_speed);
    }

    @Override
    public String getSunrise() {
        return context.getString(R.string.weather_sunrise);
    }

    @Override
    public String getSunset() {
        return context.getString(R.string.weather_sunset);
    }

    @Override
    public String getVisibility() {
        return context.getString(R.string.weather_visibility);
    }

    @Override
    public String getUnknown() {
        return context.getString(R.string.weather_unknown);
    }

    @Override
    public String getToday() {
        return context.getString(R.string.weather_today);
    }

    @Override
    public String getTomorrow() {
        return context.getString(R.string.weather_tomorrow);
    }
}
