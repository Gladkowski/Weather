package dev.gladkowski.wetaherapp.weather.repository;

import android.location.Location;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepositoryImpl;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.ForecastByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.data.forecast.ForecastResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.utils.location.LocationProvider;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeatherRepositoryTest {
    private WeatherRepository repository;

    @Mock
    private WeatherApi api;
    @Mock
    private WeatherByCoordinatesResponseConverter weatherConverter;
    @Mock
    private ForecastByCoordinatesResponseConverter forecastConverter;
    @Mock
    private LocationProvider locationProvider;
    @Mock
    private List<Forecast> mockArrayList;
    @Mock
    private Weather weather;
    @Mock
    private ForecastResponseByCoordinates forecastResponse;
    @Mock
    private WeatherResponseByCoordinates weatherResponse;
    @Mock
    private Location location;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        repository = new WeatherRepositoryImpl(api, weatherConverter,
                forecastConverter, locationProvider);
    }

    @Test
    public void getLocalWeatherShouldSuccess() {
        when(api.getWeatherByCoordinates(anyDouble(), anyDouble())).thenReturn(Single.just(weatherResponse));
        try {
            when(weatherConverter.apply(any(WeatherResponseByCoordinates.class))).thenReturn(weather);
        } catch (Exception e) {
            e.printStackTrace();
        }

        when(locationProvider.getLocation()).thenReturn(Single.just(location));

        TestObserver testObserver = repository.getLocalWeather().test();
        testObserver.assertNoErrors();
        testObserver.awaitTerminalEvent();

        verify(api, times(1)).getWeatherByCoordinates(anyDouble(), anyDouble());
    }

    @Test
    public void getLocalForecastShouldSuccess() {
        when(api.getForecastBycoordinates(anyDouble(), anyDouble())).thenReturn(Single.just(forecastResponse));
        try {
            when(forecastConverter.apply(any(ForecastResponseByCoordinates.class))).thenReturn(mockArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        when(locationProvider.getLocation()).thenReturn(Single.just(location));

        TestObserver testObserver = repository.getLocalForecast().test();
        testObserver.assertNoErrors();
        testObserver.awaitTerminalEvent();

        verify(api, times(1)).getForecastBycoordinates(anyDouble(), anyDouble());
    }
}
