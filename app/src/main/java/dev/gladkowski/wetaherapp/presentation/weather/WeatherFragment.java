package dev.gladkowski.wetaherapp.presentation.weather;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragment;
import dev.gladkowski.wetaherapp.presentation.weather.customview.PermissionNeededView;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


/**
 * Fragment that shows weather
 */
@RuntimePermissions
public class WeatherFragment extends BaseFragment<WeatherPresenter, WeatherView>
        implements WeatherView, PermissionNeededView.OnRequestPermissionListener {

    @InjectPresenter
    WeatherPresenter weatherPresenter;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_temperature)
    TextView textView;
    @BindView(R.id.view_permission_needed)
    PermissionNeededView permissionNeededView;

    public WeatherFragment() {
    }

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    WeatherPresenter provideMoviesPresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
    }

    private void initViews() {
        permissionNeededView.setCallbackListener(this);
        swipeRefreshLayout.setOnRefreshListener(() -> {
//                getPresenter().refresh();
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        WeatherFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected WeatherPresenter getPresenter() {
        return weatherPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void checkPermissions() {
        WeatherFragmentPermissionsDispatcher.loadDataWithPermissionCheck(this);
    }

    @Override
    public void showPermissionNeededView() {
        permissionNeededView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePermissionNeededView() {
        permissionNeededView.setVisibility(View.GONE);
    }

    @Override
    public void showWeatherViews() {
        textView.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setEnabled(true);
//        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideWeatherViews() {
        textView.setVisibility(View.GONE);
        swipeRefreshLayout.setEnabled(false);
//        swipeRefreshLayout.setRefreshing(false);
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Request permission by clicking a button in PermissionNeededView
     */
    @Override
    public void onRequestPermission() {
        checkPermissions();
    }

    /**
     * Permission denied
     */
    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showDeniedForLocationPermission() {
        getPresenter().onPermissionDenied();
    }

    /**
     * Permission successfully granted from the system permission request
     */
    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showNeverAskForLocationPermission() {
        getPresenter().onPermissionsGranted();
    }

    /**
     * Permission successfully granted
     */
    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    public void loadData() {
        getPresenter().onPermissionsGranted();
    }

    /**
     * Show permission request dialog
     */
    @OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showRationaleForLocationPermission(final PermissionRequest request) {
        if (getContext() != null) {
            new AlertDialog.Builder(getContext())
                    .setMessage(R.string.permission_location_message)
                    .setPositiveButton(R.string.permission_ok, (dialog, button) -> request.proceed())
                    .setNegativeButton(R.string.permission_dont_allow, (dialog, button) -> request.cancel())
                    .show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
