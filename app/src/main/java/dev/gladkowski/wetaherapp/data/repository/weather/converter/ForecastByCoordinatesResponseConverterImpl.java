package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.data.forecast.ForecastResponse;
import dev.gladkowski.wetaherapp.entity.weather.data.forecast.ForecastResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;

/**
 * Implementation of ForecastByCoordinatesResponseConverter
 */
public class ForecastByCoordinatesResponseConverterImpl implements ForecastByCoordinatesResponseConverter {

    @Override
    public List<Forecast> apply(ForecastResponseByCoordinates response) throws Exception {
        List<Forecast> list = new ArrayList<>();

        for (ForecastResponse forecastResponse : response.getWeather()) {
            list.add(new Forecast(forecastResponse.getTemperature().getDayTemperature(),
                    forecastResponse.getTemperature().getNightTemperature(),
                    forecastResponse.getWeather().get(0).getId(),
                    forecastResponse.getDateTime()));
        }

        return list;
    }
}
