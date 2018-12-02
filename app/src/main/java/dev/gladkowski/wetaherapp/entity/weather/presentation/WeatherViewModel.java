package dev.gladkowski.wetaherapp.entity.weather.presentation;

import org.joda.time.DateTime;

/**
 * View level class with current weather data
 */
public class WeatherViewModel {

    private String name;
    private String temperature;
    private String temperatureSpread;
    private String pressure;
    private String humidity;
    private WeatherCondition weatherCondition;
    private String windSpeed;
    private String sunrise;
    private String sunset;
    private String visibility;
    private String weatherDescription;
    private DateTime sunsetDateTime;
    private DateTime sunriseDateTime;

    public WeatherViewModel(String name, String temperature, String temperatureSpread,
                            String pressure, String humidity, WeatherCondition weatherCondition,
                            String windSpeed, String sunrise, String sunset, String visibility,
                            String weatherDescription, DateTime sunsetDateTime,
                            DateTime sunriseDateTime) {
        this.name = name;
        this.temperature = temperature;
        this.temperatureSpread = temperatureSpread;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
        this.windSpeed = windSpeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.visibility = visibility;
        this.weatherDescription = weatherDescription;
        this.sunsetDateTime = sunsetDateTime;
        this.sunriseDateTime = sunriseDateTime;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTemperatureSpread() {
        return temperatureSpread;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public DateTime getSunsetDateTime() {
        return sunsetDateTime;
    }

    public DateTime getSunriseDateTime() {
        return sunriseDateTime;
    }
}
