package dev.gladkowski.wetaherapp.presentation.weather.converter;

import android.support.annotation.DrawableRes;

import org.joda.time.DateTime;

import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherCondition;

/**
 * Implementation of WeatherImageConverter
 */
public class WeatherImageConverterImpl implements WeatherImageConverter {

    @DrawableRes
    @Override
    public int getImageResource(WeatherCondition condition, DateTime sunrise, DateTime sunset) {

        if (condition == WeatherCondition.THUNDERSTORM) {
            return R.drawable.ic_thunder;

        } else if (condition == WeatherCondition.DRIZZLE) {
            return R.drawable.ic_drizzle;

        } else if (condition == WeatherCondition.RAIN) {
            return R.drawable.ic_rain;

        } else if (condition == WeatherCondition.SNOW) {
            return R.drawable.ic_snow;

        } else if (condition == WeatherCondition.ATMOSPHERE) {
            return R.drawable.ic_atmosphere;

        } else if (condition == WeatherCondition.CLEAR) {
            if (isDay(sunrise, sunset)) {
                return R.drawable.ic_clear_day;
            } else {
                return R.drawable.ic_clear_night;
            }

        } else if (condition == WeatherCondition.FEW_CLOUDS) {
            return R.drawable.ic_few_clouds;

        } else if (condition == WeatherCondition.MANY_CLOUDS) {
            return R.drawable.ic_many_clouds;

        } else {
            return R.drawable.ic_few_clouds;
        }
    }

    @DrawableRes
    @Override
    public int getImageResource(WeatherCondition condition) {

        if (condition == WeatherCondition.THUNDERSTORM) {
            return R.drawable.ic_thunder;

        } else if (condition == WeatherCondition.DRIZZLE) {
            return R.drawable.ic_drizzle;

        } else if (condition == WeatherCondition.RAIN) {
            return R.drawable.ic_rain;

        } else if (condition == WeatherCondition.SNOW) {
            return R.drawable.ic_snow;

        } else if (condition == WeatherCondition.ATMOSPHERE) {
            return R.drawable.ic_atmosphere;

        } else if (condition == WeatherCondition.CLEAR) {
            return R.drawable.ic_clear_day;

        } else if (condition == WeatherCondition.FEW_CLOUDS) {
            return R.drawable.ic_few_clouds;

        } else if (condition == WeatherCondition.MANY_CLOUDS) {
            return R.drawable.ic_many_clouds;

        } else {
            return R.drawable.ic_few_clouds;
        }
    }

    private boolean isDay(DateTime sunrise, DateTime sunset) {
        return DateTime.now().getMillis() < sunset.getMillis() &&
                DateTime.now().getMillis() > sunrise.getMillis();
    }
}
