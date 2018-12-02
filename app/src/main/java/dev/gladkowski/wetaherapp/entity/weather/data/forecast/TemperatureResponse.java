package dev.gladkowski.wetaherapp.entity.weather.data.forecast;

import com.google.gson.annotations.SerializedName;

public class TemperatureResponse {

    @SerializedName("day")
    private Double dayTemperature;

    @SerializedName("night")
    private Double nightTemperature;

    public Double getDayTemperature() {
        return dayTemperature;
    }

    public Double getNightTemperature() {
        return nightTemperature;
    }
}
