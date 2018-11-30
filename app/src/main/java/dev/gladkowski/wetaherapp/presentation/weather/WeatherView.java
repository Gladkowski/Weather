package dev.gladkowski.wetaherapp.presentation.weather;


import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragmentView;

/**
 * Interface for WeatherFragment
 */
public interface WeatherView extends BaseFragmentView {

    /**
     * Check permissions
     */
    @StateStrategyType(SkipStrategy.class)
    void checkPermissions();

    /**
     * Show PermissionNeededView
     */
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showPermissionNeededView();

    /**
     * Hide PermissionNeededView
     */
    @StateStrategyType(AddToEndSingleStrategy.class)
    void hidePermissionNeededView();

    /**
     * Show views connected to weather
     */
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showWeatherViews();

    /**
     * Hide views connected to weather
     */
    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideWeatherViews();

}
