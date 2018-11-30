package dev.gladkowski.wetaherapp.utils.map;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Implementation of MapLoader
 */
public class MapBoxMapLoaderImpl implements MapLoader {

    private Context context;

    public MapBoxMapLoaderImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loadMap(@Nullable Bundle savedInstanceState, int containerViewId) {
//        SupportMapFragment mapFragment;
//
//        if (savedInstanceState == null) {
//            // Create fragment
//            final FragmentTransaction transaction = context.getChildFragmentManager().beginTransaction();
////            LatLng patagonia = new LatLng(-52.6885, -70.1395);
//
//            // Build mapboxMap
//            MapboxMapOptions options = new MapboxMapOptions();
//            options.styleUrl(Style.DARK);
//            options.camera(new CameraPosition.Builder()
//                    .zoom(12)
//                    .build());
//            options.compassEnabled(false);
//            options.rotateGesturesEnabled(false);
//            options.zoomGesturesEnabled(false);
//            options.scrollGesturesEnabled(false);
//
//
//            // Create map fragment
//            mapFragment = SupportMapFragment.newInstance(options);
//
//            // Add map fragment to parent container
//            transaction.add(containerViewId, mapFragment, "com.mapbox.map");
//            transaction.commit();
//        } else {
//            mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentByTag("com.mapbox.map");
//        }
//        mapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(MapboxMap mapboxMap) {
//                LocationComponent locationComponent = mapboxMap.getLocationComponent();
//
//                locationComponent.activateLocationComponent(getActivity()); //TODO: permission
//                locationComponent.setLocationComponentEnabled(true);
//                locationComponent.setCameraMode(CameraMode.TRACKING);
//
//                //TODO: location change listener
//
//            }
//        });
    }
}
