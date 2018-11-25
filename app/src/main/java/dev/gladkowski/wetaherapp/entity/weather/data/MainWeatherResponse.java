package dev.gladkowski.wetaherapp.entity.weather.data;

import com.google.gson.annotations.SerializedName;

public class MainWeatherResponse {

    @SerializedName("temp")
    private Integer temp;

    @SerializedName("pressure")
    private Integer pressure;

    @SerializedName("humidity")
    private Integer humidity;

    @SerializedName("temp_min")
    private Integer temp_min;

    @SerializedName("temp_max")
    private Integer temp_max;

    public Integer getTemp() {
        return temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getTemp_min() {
        return temp_min;
    }

    public Integer getTemp_max() {
        return temp_max;
    }
}
