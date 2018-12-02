package dev.gladkowski.wetaherapp.presentation.weather;


import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragmentView;

/**
 * Interface for WeatherFragment
 */
public interface WeatherView extends BaseFragmentView {

    /**
     * Show current weather data on view
     */
    @StateStrategyType(AddToEndStrategy.class)
    void showCurrentWeatherData(WeatherViewModel weatherViewModel);

    /**
     * Show swipe refresh loading
     */
    void onShowRefreshLoading();

    /**
     * Hide swipe refresh loading
     */
    void onHideRefreshLoading();
}
