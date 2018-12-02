package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponseByCoordinates {

    @SerializedName("weather")
    private List<WeatherResponse> weather;

    @SerializedName("main")
    private MainWeatherResponse main;

    @SerializedName("visibility")
    private Integer visibility;

    @SerializedName("wind")
    private WindResponse wind;

    @SerializedName("sys")
    private SystemResponse sys;

    @SerializedName("name")
    private String name;

    public List<WeatherResponse> getWeather() {
        return weather;
    }

    public MainWeatherResponse getMain() {
        return main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public WindResponse getWind() {
        return wind;
    }

    public SystemResponse getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

}
