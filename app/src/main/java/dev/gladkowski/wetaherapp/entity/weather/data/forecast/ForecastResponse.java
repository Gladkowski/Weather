package dev.gladkowski.wetaherapp.entity.weather.data.forecast;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponse;

public class ForecastResponse {

    @SerializedName("dt")
    private DateTime dateTime;

    @SerializedName("temp")
    private TemperatureResponse temperature;

    @SerializedName("weather")
    private List<WeatherResponse> weather;

    public DateTime getDateTime() {
        return dateTime;
    }

    public TemperatureResponse getTemperature() {
        return temperature;
    }

    public List<WeatherResponse> getWeather() {
        return weather;
    }
}
