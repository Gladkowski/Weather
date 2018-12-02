package dev.gladkowski.wetaherapp.presentation.weather.converter;

import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import io.reactivex.functions.Function;

/**
 * Converts Weather object into WeatherViewModel object
 */
public interface WeatherViewModelConverter extends Function<Weather, WeatherViewModel> {

}
