package dev.gladkowski.wetaherapp.presentation.weather.converter;

import android.support.annotation.DrawableRes;

import org.joda.time.DateTime;

import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherCondition;

/**
 * Converts WeatherCondition into @DrawableRes int
 */
public interface WeatherImageConverter {

    @DrawableRes
    int getImageResource(WeatherCondition condition, DateTime sunrise, DateTime sunset);

    @DrawableRes
    int getImageResource(WeatherCondition condition);
}
