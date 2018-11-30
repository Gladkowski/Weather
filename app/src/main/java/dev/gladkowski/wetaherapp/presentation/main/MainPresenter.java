package dev.gladkowski.wetaherapp.presentation.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.activity.BasePresenter;
import dev.gladkowski.wetaherapp.presentation.permission.PermissionFragment;
import io.reactivex.annotations.NonNull;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for MainActivity
 */
@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    /**
     * Router for navigation
     */
    @NonNull
    private Router router;
    @NonNull
    private FragmentManager fragmentManager;

    public MainPresenter(@NonNull Router router,
                         @NonNull FragmentManager fragmentManager) {
        this.router = router;
        this.fragmentManager = fragmentManager;
    }

    /**
     * Init screen at first launch
     */
    @Override
    public void initData() {
        navigateToPermissionFragment();
    }

    @Override
    public void onBackPressed() {
        getRouter().exit();
    }

    @Override
    @NonNull
    public Router getRouter() {
        return router;
    }

    private void navigateToPermissionFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = PermissionFragment.newInstance();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}

