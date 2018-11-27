package dev.gladkowski.wetaherapp.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.activity.BaseActivity;
import dev.gladkowski.wetaherapp.presentation.common.constants.ActivityScreens;
import dev.gladkowski.wetaherapp.presentation.common.constants.MainScreens;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragmentView;
import dev.gladkowski.wetaherapp.presentation.weather.WeatherFragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;


public class MainActivity extends BaseActivity<MainPresenter, MainView>
        implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;
    @Inject
    NavigatorHolder navigatorHolder;

    @BindView(R.id.layout_coordinator_main)
    CoordinatorLayout coordinatorLayout;


    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return presenterProvider.get();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ButterKnife.bind(this);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment instanceof BaseFragmentView) {
            ((BaseFragmentView) fragment).onBackPressed();
        } else {
            getPresenter().onBackPressed();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get view for activity
     */
    @Override
    @LayoutRes
    protected int getLayoutActivity() {
        return R.layout.activity_main;
    }

    /**
     * Get presenter
     */
    @Override
    protected MainPresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected NavigatorHolder getNavigationHolder() {
        return navigatorHolder;
    }

    /**
     * Get navigator
     */
    @Override
    protected Navigator getLocalNavigator() {
        if (localNavigator == null) {
            localNavigator = new SupportAppNavigator(this, R.id.container) {
                @Override
                protected Fragment createFragment(String screenKey, Object data) {
                    switch (screenKey) {
                        case MainScreens.WEATHER_PAGE:
                            return WeatherFragment.newInstance();
                    }
                    return null;
                }

                @Override
                public void applyCommand(Command command) {
                    super.applyCommand(command);
                }

                @Override
                protected Intent createActivityIntent(Context context, String screenKey, Object data) {
                    switch (screenKey) {
                        case ActivityScreens.MAIN_ACTIVITY:
                            return MainActivity.newIntent(context);
                    }
                    return null;
                }

                @Override
                protected void showSystemMessage(String message) {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

                    snackbar.show();
                }

                @Override
                protected void exit() {
                    finish();
                }
            };
        }
        return localNavigator;
    }

    /**
     * Set title
     */
    @Override
    public void onSetTitle(String title) {

    }
}