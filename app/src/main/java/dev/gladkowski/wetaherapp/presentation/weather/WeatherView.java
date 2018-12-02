package dev.gladkowski.wetaherapp.presentation.weather;


import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
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
     * Show the list of items
     */
    @StateStrategyType(AddToEndStrategy.class)
    void showList(List<BaseForecastItem> items);

    /**
     * Show swipe refresh loading
     */
    void onShowRefreshLoading();

    /**
     * Hide swipe refresh loading
     */
    void onHideRefreshLoading();
}
