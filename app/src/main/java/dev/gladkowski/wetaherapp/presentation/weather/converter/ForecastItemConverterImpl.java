package dev.gladkowski.wetaherapp.presentation.weather.converter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.domain.ConditionsConstants;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
import dev.gladkowski.wetaherapp.entity.weather.presentation.ForecastItem;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherCondition;
import dev.gladkowski.wetaherapp.presentation.weather.provider.WeatherResourceProvider;

/**
 * Implementation of ForecastItemConverter
 */
public class ForecastItemConverterImpl implements ForecastItemConverter {

    private WeatherResourceProvider resourceProvider;

    public ForecastItemConverterImpl(WeatherResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public List<BaseForecastItem> apply(List<Forecast> forecasts) throws Exception {
        List<BaseForecastItem> itemList = new ArrayList<>();

        for (Forecast forecast : forecasts) {
            itemList.add(new ForecastItem(
                    convertTemperatureDayNight(forecast.getTemperatureDay(),
                            forecast.getTemperatureNight()),
                    convertCondition(forecast.getWeatherCondition()),
                    convertDate(forecast.getDate())));
        }

        return itemList;
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

    private String convertTemperatureDayNight(Double doubleTemperatureDay,
                                              Double doubleTemperatureNight) {
        return convertTemperature(doubleTemperatureDay)
                .concat("|")
                .concat(convertTemperature(doubleTemperatureNight));
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

    private String convertDate(DateTime dateTime) {
        if (isToday(dateTime)) {
            return resourceProvider.getToday();
        } else if (isTomorrow(dateTime)) {
            return resourceProvider.getTomorrow();
        } else {
            return dateTime.toString(DateTimeFormat.forPattern("dd.MM"));
        }
    }

    private boolean isToday(DateTime time) {
        return LocalDate.now().compareTo(new LocalDate(time)) == 0;
    }

    private boolean isTomorrow(DateTime time) {
        return LocalDate.now().plusDays(1).compareTo(new LocalDate(time)) == 0;
    }
}
