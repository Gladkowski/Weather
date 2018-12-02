package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class SystemResponse {

    @SerializedName("sunrise")
    private DateTime sunrise;

    @SerializedName("sunset")
    private DateTime sunset;

    public DateTime getSunrise() {
        return sunrise;
    }

    public DateTime getSunset() {
        return sunset;
    }
}
