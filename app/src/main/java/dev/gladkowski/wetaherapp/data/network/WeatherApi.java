package dev.gladkowski.wetaherapp.data.network;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    /**
     * Get weather by coordinates
     *
     * @param lat latitude
     * @param lon longitude
     */
    @GET("/data/2.5/weather?")
    Single<WeatherResponseByCoordinates> getWeatherBycoordinates(@Query("lat") float lat,
                                                                 @Query("lon") float lon);

}
