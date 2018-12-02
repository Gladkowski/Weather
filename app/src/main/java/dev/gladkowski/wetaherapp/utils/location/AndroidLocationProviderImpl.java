package dev.gladkowski.wetaherapp.utils.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import io.reactivex.Single;
import io.reactivex.subjects.SingleSubject;

/**
 * Android implementation of LocationProvider
 */
public class AndroidLocationProviderImpl implements LocationProvider,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {

    private Context context;
    private static final int INTERVAL = 10000;
    private static final int FASTEST_INTERVAL = 5000;
    private GoogleApiClient client;

    private SingleSubject<Location> subject = SingleSubject.create();

    public AndroidLocationProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public Single<Location> getLocation() {
        requestLocation();
        return subject;
    }

    private void requestLocation() {

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(INTERVAL);
        locationRequest.setFastestInterval(FASTEST_INTERVAL);

        client = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        client.connect();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(client);
        subject.onSuccess(lastLocation);
    }

    @Override
    public void onConnectionSuspended(int i) {
        client.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        subject.onSuccess(location);
    }
}
