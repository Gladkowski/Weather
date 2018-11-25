package dev.gladkowski.wetaherapp.data.repository.weather;

import dev.gladkowski.wetaherapp.data.network.WeatherApi;
import dev.gladkowski.wetaherapp.data.repository.weather.converter.WeatherByCoordinatesResponseConverter;
import dev.gladkowski.wetaherapp.entity.weather.domain.Weather;
import dev.gladkowski.wetaherapp.utils.location.LocationProvider;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of WeatherRepository
 */
public class WeatherRepositoryImpl implements WeatherRepository
//        ,
//        GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener,
//        com.google.android.gms.location.LocationListener
{

    private WeatherApi weatherApi;
    private WeatherByCoordinatesResponseConverter converter;
    private LocationProvider locationProvider;

    public WeatherRepositoryImpl(WeatherApi weatherApi,
                                 WeatherByCoordinatesResponseConverter converter,
                                 LocationProvider locationProvider) {
        this.weatherApi = weatherApi;
        this.converter = converter;
        this.locationProvider = locationProvider;
    }

    @Override
    public Single<Weather> getLocalWeather() {
        return locationProvider.getLocation()
                .flatMap(location ->
                        weatherApi.getWeatherBycoordinates(location.getLatitude(), location.getLongitude())
                                .subscribeOn(Schedulers.io())
                )
                .map(converter);
    }


    ///////////////////
//    private GoogleApiClient client;
//    private LocationRequest locationRequest;
//    private FusedLocationProviderClient fusedLocationProviderClient;
//
//    private void locationTest() {
//
//        LocationRequest locationRequest = new LocationRequest();
//        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
//        locationRequest.setInterval(10000);
//        locationRequest.setFastestInterval(5000);
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
//
//        client = new GoogleApiClient.Builder(context)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
//        client.connect();
//    }
//
//    @SuppressLint("MissingPermission")
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(client);
//        Log.v("LOCATION_TEST", String.valueOf(mLastLocation.getLatitude()));
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//        client.connect();
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        Log.v("LOCATION_TEST", String.valueOf(location.getLatitude()));
//    }
}
