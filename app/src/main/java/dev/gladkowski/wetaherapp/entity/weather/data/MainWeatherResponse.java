package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class MainWeatherResponse {

    @SerializedName("temp")
    private Float temp;

    @SerializedName("pressure")
    private Integer pressure;

    @SerializedName("humidity")
    private Integer humidity;

    @SerializedName("temp_min")
    private Float temp_min;

    @SerializedName("temp_max")
    private Float temp_max;

    public Float getTemp() {
        return temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public Float getTemp_max() {
        return temp_max;
    }
}
