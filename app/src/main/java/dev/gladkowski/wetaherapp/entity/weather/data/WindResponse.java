package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class WindResponse {

    @SerializedName("speed")
    private Integer speed;

    public Integer getSpeed() {
        return speed;
    }
}
