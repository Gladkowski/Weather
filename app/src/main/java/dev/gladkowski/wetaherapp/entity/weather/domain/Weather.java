package dev.gladkowski.wetaherapp.entity.weather.domain;

import org.joda.time.DateTime;

/**
 * Domain level class with current weather data
 */
public class Weather {

    private String name;
    private Double temperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private Integer pressure;
    private Integer humidity;
    private Integer weatherCondition;
    private Double windSpeed;
    private DateTime sunrise;
    private DateTime sunset;
    private Integer visibility;
    private String weatherDescription;

    public Weather(String name, Double temperature, Double temperatureMin, Double temperatureMax,
                   Integer pressure, Integer humidity, Integer weatherCondition, Double windSpeed,
                   DateTime sunrise, DateTime sunset, Integer visibility,
                   String weatherDescription) {
        this.name = name;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
        this.windSpeed = windSpeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.visibility = visibility;
        this.weatherDescription = weatherDescription;
    }

    public String getName() {
        return name;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getWeatherCondition() {
        return weatherCondition;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public DateTime getSunrise() {
        return sunrise;
    }

    public DateTime getSunset() {
        return sunset;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}
