package dev.gladkowski.wetaherapp.presentation.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
import dev.gladkowski.wetaherapp.entity.weather.presentation.WeatherViewModel;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseMapFragment;
import dev.gladkowski.wetaherapp.presentation.weather.adapter.ForecastAdapter;
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
    @BindView(R.id.text_date)
    TextView textDescription;
    @BindView(R.id.text_temperature_spread)
    TextView textTemperatureSpread;

    @BindView(R.id.text_sunrise)
    TextView textSunrise;
    @BindView(R.id.text_sunset)
    TextView textSunset;
    @BindView(R.id.text_visibility)
    TextView textVisibility;
    @BindView(R.id.text_humidity)
    TextView textHumidity;
    @BindView(R.id.text_pressure)
    TextView textPressure;
    @BindView(R.id.text_wind_speed)
    TextView textWindSpeed;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ForecastAdapter forecastAdapter;


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
        initList();
    }

    /**
     * SwipeRefresh and MapView initialization
     */
    @SuppressLint("MissingPermission")
    private void initViews() {
        swipeRefreshLayout.setOnRefreshListener(() -> getPresenter().refresh());

        mapView.getMapAsync(mapboxMap -> {
            if (getActivity() != null) {
                LocationComponent locationComponent = mapboxMap.getLocationComponent();
                locationComponent.activateLocationComponent(getActivity());
                locationComponent.setLocationComponentEnabled(true);
                locationComponent.setCameraMode(CameraMode.TRACKING);
            }
        });
    }

    /**
     * LinearLayout initialization
     */
    private void initList() {
        forecastAdapter = new ForecastAdapter(imageConverter);
        recyclerView.setAdapter(forecastAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
                viewModel.getSunriseDateTime(),
                viewModel.getSunsetDateTime()));
        textTemperature.setText(viewModel.getTemperature());
        textDescription.setText(viewModel.getWeatherDescription());
        textTemperatureSpread.setText(viewModel.getTemperatureSpread());

        textSunrise.setText(viewModel.getSunrise());
        textSunset.setText(viewModel.getSunset());
        textVisibility.setText(viewModel.getVisibility());
        textHumidity.setText(viewModel.getHumidity());
        textPressure.setText(viewModel.getPressure());
        textWindSpeed.setText(viewModel.getWindSpeed());
    }

    @Override
    public void showList(List<BaseForecastItem> items) {
        forecastAdapter.addItems(items);
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onShowRefreshLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onHideRefreshLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
