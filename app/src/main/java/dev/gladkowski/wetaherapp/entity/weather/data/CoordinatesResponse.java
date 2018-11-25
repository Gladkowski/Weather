package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class CoordinatesResponse {

    @SerializedName("lon")
    private Float lon;

    @SerializedName("lat")
    private Float lat;

    public Float getLon() {
        return lon;
    }

    public Float getLat() {
        return lat;
    }
}
