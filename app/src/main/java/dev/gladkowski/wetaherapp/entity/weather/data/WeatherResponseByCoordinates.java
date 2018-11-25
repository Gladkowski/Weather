package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;

public class WeatherResponseByCoordinates {

    @SerializedName("coord")
    private CoordinatesResponse coord;

    @SerializedName("weather")
    private List<WeatherResponse> weather;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private MainWeatherResponse main;

    @SerializedName("visibility")
    private Integer visibility;

    @SerializedName("wind")
    private WindResponse wind;

    @SerializedName("clouds")
    private CloudsResponse clouds;

    @SerializedName("dt")
    private DateTime dt;

    @SerializedName("sys")
    private SystemResponse sys;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private Integer cod;

    public CoordinatesResponse getCoord() {
        return coord;
    }

    public List<WeatherResponse> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
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

    public CloudsResponse getClouds() {
        return clouds;
    }

    public DateTime getDt() {
        return dt;
    }

    public SystemResponse getSys() {
        return sys;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }
}
