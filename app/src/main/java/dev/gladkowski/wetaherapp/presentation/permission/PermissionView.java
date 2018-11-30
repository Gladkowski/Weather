package dev.gladkowski.wetaherapp.presentation.permission;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragmentView;

/**
 * Interface for PermissionFragment
 */
public interface PermissionView extends BaseFragmentView {

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
}
