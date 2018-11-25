package dev.gladkowski.wetaherapp.utils.location;

import android.location.Location;

import io.reactivex.Single;

/**
 * Provides current location
 */
public interface LocationProvider {

    /**
     * Get current location
     */
    Single<Location> getLocation();
}
