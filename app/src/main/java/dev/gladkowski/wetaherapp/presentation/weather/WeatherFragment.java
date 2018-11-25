package dev.gladkowski.wetaherapp.presentation.weather;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragment;
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
public class WeatherFragment extends BaseFragment<WeatherPresenter, WeatherView> implements WeatherView {

    @InjectPresenter
    WeatherPresenter weatherPresenter;

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
    public void onCheckPermissions() {
        WeatherFragmentPermissionsDispatcher.loadDataWithPermissionCheck(this);
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Permission denied
     */
    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showDeniedForLocationPermission() {
        Toast.makeText(getContext(), "denied", Toast.LENGTH_SHORT).show();
//        getPresenter().showDeniedForLocation();
    }

    /**
     * Permission successfully granted from the system permission request
     */
    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showNeverAskForLocationPermission() {
        Toast.makeText(getContext(), "never", Toast.LENGTH_SHORT).show();
    }

    /**
     * Permission successfully granted
     */
    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    public void loadData() {
        Toast.makeText(getContext(), "granted", Toast.LENGTH_SHORT).show();
//        getPresenter().onPermissionsGranted();
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
