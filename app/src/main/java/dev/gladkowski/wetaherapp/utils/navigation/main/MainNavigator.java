package dev.gladkowski.wetaherapp.utils.navigation.main;

import android.support.annotation.IdRes;

/**
 * Interface for navigation between fragments in MainActivity
 */
public interface MainNavigator {

    /**
     * Set container for fragment
     */
    void setContainer(@IdRes int container);

    /**
     * Replace current fragment
     */
    void replaceWith(String fragmentTag);

    /**
     * Navigate to fragment
     */
    void navigateTo(String fragmentTag);

    /**
     * Navigate to fragment
     */
    void back();
}
