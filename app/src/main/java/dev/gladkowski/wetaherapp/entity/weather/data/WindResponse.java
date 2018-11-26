package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class WindResponse {

    @SerializedName("speed")
    private Double speed;

    public Double getSpeed() {
        return speed;
    }
}
