package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class SystemResponse {

    @SerializedName("type")
    private Integer type;

    @SerializedName("id")
    private Integer id;

    @SerializedName("message")
    private Float message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private DateTime sunrise;

    @SerializedName("sunset")
    private DateTime sunset;

    public Integer getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public Float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public DateTime getSunrise() {
        return sunrise;
    }

    public DateTime getSunset() {
        return sunset;
    }
}
