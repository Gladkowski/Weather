package dev.gladkowski.wetaherapp.presentation.weather.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

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
                convertTemperatureSpread(weather.getTemperatureMin(), weather.getTemperatureMax()), //
                convertPressure(weather.getPressure()),
                convertHumidity(weather.getHumidity()),
                convertCondition(weather.getWeatherCondition()),
                convertWindSpeed(weather.getWindSpeed()),
                convertSunrise(weather.getSunrise()),
                convertSunset(weather.getSunset()),
                convertVisibility(weather.getVisibility()),
                capitalize(weather.getWeatherDescription()),
                weather.getSunset(),
                weather.getSunrise());
    }

    private String convertTemperature(Double doubleTemperature) {
        int temperature = (int) Math.round(doubleTemperature);

        if (temperature > 0) {
            return "+"
                    .concat(String.valueOf(temperature))
                    .concat(resourceProvider.getCelsius());
        } else {
            return String.valueOf(temperature)
                    .concat(resourceProvider.getCelsius());
        }
    }

    private String convertTemperatureSpread(Double doubleTemperatureMin, Double doubleTemperatureMax) {
        return convertTemperature(doubleTemperatureMin)
                .concat("/")
                .concat(convertTemperature(doubleTemperatureMax));
    }

    private String convertPressure(Integer pressure) {
        if (pressure == null) {
            return resourceProvider.getPressure()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getPressure()
                    .concat(":")
                    .concat(" ")
                    .concat(String.valueOf(pressure));
        }
    }

    private String convertHumidity(Integer humidity) {
        if (humidity == null) {
            return resourceProvider.getHumidity()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getHumidity()
                    .concat(":")
                    .concat(" ")
                    .concat(String.valueOf(humidity))
                    .concat(resourceProvider.getPercents());
        }
    }

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

    private String convertWindSpeed(Double speed) {
        if (speed == null) {
            return resourceProvider.getWindSpeed()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getWindSpeed()
                    .concat(":")
                    .concat(" ")
                    .concat(String.valueOf((int) Math.round(speed)))
                    .concat(" ")
                    .concat(resourceProvider.getMetersPerSecond());
        }
    }

    private String convertSunrise(DateTime dateTime) {
        if (dateTime == null) {
            return resourceProvider.getSunrise()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getSunrise()
                    .concat(":")
                    .concat(" ")
                    .concat(dateTime.toString(DateTimeFormat.forPattern("HH:mm")));
        }
    }

    private String convertSunset(DateTime dateTime) {
        if (dateTime == null) {
            return resourceProvider.getSunrise()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getSunset()
                    .concat(":")
                    .concat(" ")
                    .concat(dateTime.toString(DateTimeFormat.forPattern("HH:mm")));
        }
    }

    private String convertVisibility(Integer visibility) {
        if (visibility == null) {
            return resourceProvider.getVisibility()
                    .concat(":")
                    .concat(" ")
                    .concat(resourceProvider.getUnknown());
        } else {
            return resourceProvider.getVisibility()
                    .concat(":")
                    .concat(" ")
                    .concat(String.valueOf(visibility))
                    .concat(" ")
                    .concat(resourceProvider.getMeters());
        }
    }

    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
