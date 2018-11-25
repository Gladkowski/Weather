package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import io.reactivex.functions.Function;

/**
 * Converts WeatherResponseByCoordinates into Weather
 */
public interface WeatherByCoordinatesResponseConverter extends Function<WeatherResponseByCoordinates, Weather> {
}
