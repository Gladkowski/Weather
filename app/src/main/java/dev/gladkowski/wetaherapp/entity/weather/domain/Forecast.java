package dev.gladkowski.wetaherapp.entity.weather.domain;

import org.joda.time.DateTime;

/**
 * Domain level class with weather forecast data
 */
public class Forecast {

    private Double temperatureDay;
    private Double temperatureNight;
    private Integer weatherCondition;
    private DateTime date;

    public Forecast(Double temperatureDay, Double temperatureNight, Integer weatherCondition,
                    DateTime date) {
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.weatherCondition = weatherCondition;
        this.date = date;
    }

    public Double getTemperatureDay() {
        return temperatureDay;
    }

    public Double getTemperatureNight() {
        return temperatureNight;
    }

    public Integer getWeatherCondition() {
        return weatherCondition;
    }

    public DateTime getDate() {
        return date;
    }
}
