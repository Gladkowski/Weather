package dev.gladkowski.wetaherapp.presentation.permission;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * Fragment that checks permissions
 */
@RuntimePermissions
public class PermissionFragment extends BaseFragment<PermissionPresenter, PermissionView>
        implements PermissionView, PermissionNeededView.OnRequestPermissionListener {

    @InjectPresenter
    PermissionPresenter permissionPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_permission_needed)
    PermissionNeededView permissionNeededView;

    public PermissionFragment() {
    }

    public static PermissionFragment newInstance() {
        PermissionFragment fragment = new PermissionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    PermissionPresenter provideMoviesPresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permission, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
    }

    private void initViews() {
        permissionNeededView.setCallbackListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected PermissionPresenter getPresenter() {
        return permissionPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onSetTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void checkPermissions() {
        PermissionFragmentPermissionsDispatcher.loadDataWithPermissionCheck(this);
    }

    @Override
    public void showPermissionNeededView() {
        permissionNeededView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePermissionNeededView() {
        permissionNeededView.setVisibility(View.GONE);
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
                    .setCancelable(false)
                    .setMessage(R.string.permission_location_message)
                    .setPositiveButton(R.string.permission_ok, (dialog, button) -> request.proceed())
                    .setNegativeButton(R.string.permission_dont_allow, (dialog, button) -> request.cancel())
                    .show();
        }
    }
}
