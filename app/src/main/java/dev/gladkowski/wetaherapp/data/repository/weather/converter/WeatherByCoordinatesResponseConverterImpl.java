package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.ConditionsConstants;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherCondition;

/**
 * Implementation of WeatherByCoordinatesResponseConverter
 */
public class WeatherByCoordinatesResponseConverterImpl implements WeatherByCoordinatesResponseConverter {

    @Override
    public Weather apply(WeatherResponseByCoordinates response) throws Exception {
        return new Weather(response.getMain().getTemp(),
                response.getMain().getTempMin(),
                response.getMain().getTempMax(),
                response.getMain().getPressure(),
                response.getMain().getHumidity(),
                response.getWeather().get(0).getId(),
                response.getWind().getSpeed(),
                response.getSys().getSunrise(),
                response.getSys().getSunset(),
                response.getVisibility(),
                response.getWeather().get(0).getDescription());
    }

    /**
     * Convert weather condition id to weather condition
     */
    private WeatherCondition convertCondition(Integer condition) {
        if (condition >= ConditionsConstants.THUNDERSTORM
                && condition < ConditionsConstants.DRIZZLE) {
            return WeatherCondition.THUNDERSTORM;
        } else if (condition >= ConditionsConstants.DRIZZLE
                && condition < ConditionsConstants.RAIN) {
            return WeatherCondition.DRIZZLE;
        } else if (condition >= ConditionsConstants.RAIN
                && condition < ConditionsConstants.SNOW) {
            return WeatherCondition.RAIN;
        } else if (condition >= ConditionsConstants.SNOW
                && condition < ConditionsConstants.ATMOSPHERE) {
            return WeatherCondition.SNOW;
        } else if (condition >= ConditionsConstants.ATMOSPHERE
                && condition < ConditionsConstants.CLEAR) {
            return WeatherCondition.ATMOSPHERE;
        } else if (condition == ConditionsConstants.CLEAR) {
            return WeatherCondition.CLEAR;
        } else if (condition == ConditionsConstants.FEW_CLOUDS) {
            return WeatherCondition.FEW_CLOUDS;
        } else if (condition >= ConditionsConstants.MANY_CLOUDS) {
            return WeatherCondition.MANY_CLOUDS;
        } else return WeatherCondition.FEW_CLOUDS;
    }
}
