package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class CoordinatesResponse {

    @SerializedName("lon")
    private Double lon;

    @SerializedName("lat")
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }
}
