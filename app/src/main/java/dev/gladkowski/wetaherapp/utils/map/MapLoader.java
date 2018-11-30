package dev.gladkowski.wetaherapp.utils.map;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

/**
 * Interface for loading the map into container view
 */
public interface MapLoader {


    /**
     * Load map into container view
     *
     * @param savedInstanceState Bundle from Fragment
     * @param containerViewId id of View
     */
    void loadMap(@Nullable Bundle savedInstanceState, @IdRes int containerViewId);
}
