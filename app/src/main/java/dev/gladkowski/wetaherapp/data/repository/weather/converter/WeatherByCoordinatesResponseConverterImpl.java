package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;

/**
 * Implementation of WeatherByCoordinatesResponseConverter
 */
public class WeatherByCoordinatesResponseConverterImpl implements WeatherByCoordinatesResponseConverter {

    @Override
    public Weather apply(WeatherResponseByCoordinates response) throws Exception {
        return new Weather(response.getMain().getTemp(),
                response.getMain().getPressure(),
                response.getMain().getHumidity());
    }
}
