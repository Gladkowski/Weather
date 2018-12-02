package dev.gladkowski.wetaherapp.presentation.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.domain.ConditionsConstants;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherCondition;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import dev.gladkowski.wetaherapp.presentation.weather.provider.WeatherResourceProvider;

/**
 * Implementation of WeatherViewModelConverter
 */
public class WeatherViewModelConverterImpl implements WeatherViewModelConverter {

    private WeatherResourceProvider resourceProvider;

    public WeatherViewModelConverterImpl(WeatherResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public WeatherViewModel apply(Weather weather) throws Exception {
        return new WeatherViewModel(weather.getName(),
                convertTemperature(weather.getTemperature()),
                convertTempertureSpread(weather.getTemperatureMin(), weather.getTemperatureMax()),
                String.valueOf(weather.getPressure()),
                String.valueOf(weather.getHumidity()),
                convertCondition(weather.getWeatherCondition()), //
                String.valueOf(weather.getWindSpeed()),
                String.valueOf(weather.getSunrise()),
                String.valueOf(weather.getSunset()),
                String.valueOf(weather.getVisibility()),
                capitalize(weather.getWeatherDescription()),
                weather.getSunset(),
                weather.getSunrise());
    }

    private String convertTemperature(Double doubleTemperature) {
        int temperature = (int) Math.round(doubleTemperature);

        if (temperature > 0) {
            return "+"
                    .concat(String.valueOf(temperature))
                    .concat(resourceProvider.getCelcius());
        } else {
            return String.valueOf(temperature)
                    .concat(resourceProvider.getCelcius());
        }
    }

    private String convertTempertureSpread(Double doubleTemperatureMin, Double doubleTemperatureMax) {
        return convertTemperature(doubleTemperatureMin)
                .concat("/")
                .concat(convertTemperature(doubleTemperatureMax));
    }

    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
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
