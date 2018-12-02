package dev.gladkowski.wetaherapp.data.network;

import dev.gladkowski.wetaherapp.entity.weather.data.WeatherResponseByCoordinates;
import dev.gladkowski.wetaherapp.entity.weather.data.forecast.ForecastResponseByCoordinates;
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
    Single<WeatherResponseByCoordinates> getWeatherByCoordinates(@Query("lat") double lat,
                                                                 @Query("lon") double lon);

    /**
     * Get weather forecast by coordinates
     *
     * @param lat latitude
     * @param lon longitude
     */
    @GET("/data/2.5/forecast/daily?")
    Single<ForecastResponseByCoordinates> getForecastBycoordinates(@Query("lat") double lat,
                                                                   @Query("lon") double lon);
}
