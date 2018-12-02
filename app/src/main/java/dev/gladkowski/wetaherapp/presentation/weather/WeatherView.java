package dev.gladkowski.wetaherapp.presentation.weather;


import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragmentView;

/**
 * Interface for WeatherFragment
 */
public interface WeatherView extends BaseFragmentView {

    /**
     * Show current weather data on view
     */
    void showCurrentWeatherData(WeatherViewModel weatherViewModel);

}
