package dev.gladkowski.wetaherapp.entity.weather.domain;

/**
 * Domain level class with current weather data
 */
public class Weather {

    private Integer temperature;
    private Integer pressure;
    private Integer humidity;

    public Weather(Integer temperature, Integer pressure, Integer humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }
}
