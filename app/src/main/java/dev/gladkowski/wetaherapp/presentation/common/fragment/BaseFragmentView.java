package dev.gladkowski.wetaherapp.presentation.common.fragment;


import dev.gladkowski.wetaherapp.presentation.common.activity.BaseMvpView;

/**
 * Base interface for fragments
 */
public interface BaseFragmentView extends BaseMvpView {

    /**
     * Triggered on back button pressed
     */
    void onBackPressed();
}
