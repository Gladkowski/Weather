package dev.gladkowski.wetaherapp.presentation.common.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.mapbox.mapboxsdk.maps.MapView;

import dev.gladkowski.wetaherapp.presentation.common.activity.BasePresenter;

/**
 * Base class for Fragment that contains MapBox MapView
 *
 * @param <Presenter>
 * @param <BaseView>
 */
public abstract class BaseMapFragment<Presenter extends BasePresenter, BaseView extends BaseFragmentView>
        extends BaseFragment<Presenter, BaseView> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMapView().onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getMapView().onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMapView().onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMapView().onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        getMapView().onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        getMapView().onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMapView().onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        getMapView().onDestroy();
        super.onDestroyView();
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get mapVie
     */
    protected abstract MapView getMapView();

}
