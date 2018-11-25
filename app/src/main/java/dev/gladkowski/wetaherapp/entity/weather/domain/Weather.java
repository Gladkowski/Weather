package dev.gladkowski.wetaherapp.entity.weather.domain;

/**
 * Domain level class with current weather data
 */
public class Weather {

    private Float temperature;
    private Integer pressure;
    private Integer humidity;

    public Weather(Float temperature, Integer pressure, Integer humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }
}
