package dev.gladkowski.wetaherapp.entity.weather.data.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponseByCoordinates {

    @SerializedName("cod")
    private Integer cod;

    @SerializedName("cnt")
    private Integer count;

    @SerializedName("list")
    private List<ForecastResponse> weather;

    public Integer getCod() {
        return cod;
    }

    public Integer getCount() {
        return count;
    }

    public List<ForecastResponse> getWeather() {
        return weather;
    }
}
