package dev.gladkowski.wetaherapp.presentation.weather.converter;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
import io.reactivex.functions.Function;

/**
 * Converts List<Forecast> object into List<BaseForecastItem> object
 */
public interface ForecastItemConverter extends Function<List<Forecast>, List<BaseForecastItem>> {
}
