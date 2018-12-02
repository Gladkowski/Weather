package dev.gladkowski.wetaherapp.data.repository.weather.converter;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.data.forecast.ForecastResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import io.reactivex.functions.Function;

/**
 * Converts ForecastResponseByCoordinates into List<Forecast>>
 */
public interface ForecastByCoordinatesResponseConverter extends Function<ForecastResponseByCoordinates, List<Forecast>> {
}
