package dev.gladkowski.wetaherapp.presentation.weather;


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
    void onCheckPermissions();
}
