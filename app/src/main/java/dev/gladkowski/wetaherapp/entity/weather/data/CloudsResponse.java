package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class CloudsResponse {

    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
}
