package dev.gladkowski.wetaherapp.utils.location;

import android.content.Context;
import android.location.Location;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.Single;
import io.reactivex.subjects.SingleSubject;

/**
 * Implementation of LocationProvider
 */
public class SmartLocationProviderImpl implements LocationProvider {

    private Context context;

    public SmartLocationProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public Single<Location> getLocation() {
        SingleSubject<Location> subject = SingleSubject.create();

        SmartLocation.with(context).location()
                .oneFix()
                .start(subject::onSuccess);

        return subject;
    }
}
