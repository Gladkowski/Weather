package dev.gladkowski.wetaherapp.weather.interactor;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import dev.gladkowski.wetaherapp.data.repository.weather.WeatherRepository;
import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractor;
import dev.gladkowski.wetaherapp.domain.weather.WeatherInteractorImpl;
import dev.gladkowski.wetaherapp.entity.weather.domain.Forecast;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.rxutils.RxImmediateSchedulerRule;
import dev.gladkowski.wetaherapp.utils.rx.ErrorProcessing;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import dev.gladkowski.wetaherapp.utils.rx.RxUtils;
import dev.gladkowski.wetaherapp.utils.rx.SingleErrorHandler;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeatherInteractorTest {
    private WeatherInteractor interactor;

    @ClassRule
    public static final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();

    @Mock
    private WeatherRepository repository;
    @Mock
    private SingleErrorHandler singleErrorHandler;
    @Mock
    private List<Forecast> mockArrayList;
    @Mock
    private Weather weather;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RxUtils rxUtils = new RxUtils();
        ErrorResourceProvider mockErrorRes = mock(ErrorResourceProvider.class);
        ErrorProcessing errorProcessing = new ErrorProcessing(mockErrorRes);
        singleErrorHandler = new SingleErrorHandler(errorProcessing);
        interactor = new WeatherInteractorImpl(repository, singleErrorHandler, rxUtils);
    }

    @Test
    public void getLocalWeatherShouldSuccess() {

        when(repository.getLocalWeather()).thenReturn(Single.just(weather));

        TestObserver testObserver = interactor.getLocalWeather().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();

        verify(repository, times(1)).getLocalWeather();
    }

    @Test
    public void getLocalForecastShouldSuccess() {

        when(repository.getLocalForecast()).thenReturn(Single.just(mockArrayList));

        TestObserver testObserver = interactor.getLocalForecast().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();

        verify(repository, times(1)).getLocalForecast();
    }
}
