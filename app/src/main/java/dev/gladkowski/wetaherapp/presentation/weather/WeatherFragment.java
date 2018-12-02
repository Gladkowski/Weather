package dev.gladkowski.wetaherapp.presentation.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.maps.MapView;

import javax.inject.Inject;

import butterknife.BindView;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseMapFragment;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherImageConverter;


/**
 * Fragment that shows weather
 */
public class WeatherFragment extends BaseMapFragment<WeatherPresenter, WeatherView>
        implements WeatherView {

    @InjectPresenter
    WeatherPresenter weatherPresenter;

    @Inject
    WeatherImageConverter imageConverter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.map_view)
    MapView mapView;

    @BindView(R.id.image_weather_condition)
    ImageView imageWeatherCondition;
    @BindView(R.id.text_temperature)
    TextView textTemperature;
    @BindView(R.id.text_description)
    TextView textDescription;
    @BindView(R.id.text_temperature_spread)
    TextView textTemperatureSpread;


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

    @SuppressLint("MissingPermission")
    private void initViews() {
        mapView.getMapAsync(mapboxMap -> {
            if (getActivity() != null) {
                LocationComponent locationComponent = mapboxMap.getLocationComponent();
                locationComponent.activateLocationComponent(getActivity());
                locationComponent.setLocationComponentEnabled(true);
                locationComponent.setCameraMode(CameraMode.TRACKING);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
//                getPresenter().refresh();
        });
        toolbar.inflateMenu(R.menu.menu_settings);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_settings) {
//                getPresenter().onShowSettingsDialog();
            }

            return false;
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected WeatherPresenter getPresenter() {
        return weatherPresenter;
    }

    @Override
    public MapView getMapView() {
        return mapView;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onSetTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void showCurrentWeatherData(WeatherViewModel viewModel) {
        onSetTitle(viewModel.getName());
        imageWeatherCondition.setImageResource(imageConverter.getImageResource(
                viewModel.getWeatherCondition(),
                viewModel.getSunriseDatetTime(),
                viewModel.getSunsetDateTime()));
        textTemperature.setText(viewModel.getTemperature());
        textDescription.setText(viewModel.getWeatherDescription());
        textTemperatureSpread.setText(viewModel.getTemperatureSpread());
    }


    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////


}
