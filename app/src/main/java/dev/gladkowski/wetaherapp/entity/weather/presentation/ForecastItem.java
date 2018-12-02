package dev.gladkowski.wetaherapp.entity.weather.presentation;

/**
 * View level class with forecast weather data
 */
public class ForecastItem extends BaseForecastItem {

    private String temperatureDayNight;
    private WeatherCondition weatherCondition;
    private String date;

    public ForecastItem(String temperatureDayNight, WeatherCondition weatherCondition,
                        String date) {
        this.temperatureDayNight = temperatureDayNight;
        this.weatherCondition = weatherCondition;
        this.date = date;
    }

    public String getTemperatureDayNight() {
        return temperatureDayNight;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public String getDate() {
        return date;
    }
}
