package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;

/**
 * Implementation of WeatherByCoordinatesResponseConverter
 */
public class WeatherByCoordinatesResponseConverterImpl implements WeatherByCoordinatesResponseConverter {

    @Override
    public Weather apply(WeatherResponseByCoordinates response) throws Exception {
        return new Weather(response.getName(),
                response.getMain().getTemp(),
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
}
