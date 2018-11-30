package dev.gladkowski.wetaherapp.utils.navigation.main;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import dev.gladkowski.wetaherapp.presentation.weather.WeatherFragment;


/**
 * Implementation of MainNavigator
 */
public class MainNavigatorImpl implements MainNavigator {

    private FragmentManager manager;
    @IdRes
    private int container;

    public MainNavigatorImpl(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public void setContainer(int container) {
        this.container = container;
    }

    @Override
    public void replaceWith(String fragmentTag) { //TODO: check
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = WeatherFragment.newInstance();
        transaction.replace(container, fragment, fragmentTag);
        transaction.commit();
    }

    @Override
    public void navigateTo(String fragmentTag) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = WeatherFragment.newInstance();
        transaction.add(container, fragment, fragmentTag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void back() {
        if (manager.getBackStackEntryCount() > 1) {
            manager.popBackStackImmediate();
        } else {
            //Nothing in the back stack, so exit
//            super.onBackPressed();
        }
    }
}
