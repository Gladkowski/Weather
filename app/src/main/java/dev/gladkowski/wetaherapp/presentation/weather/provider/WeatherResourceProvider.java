package dev.gladkowski.wetaherapp.presentation.weather.provider;

/**
 * Provide resources for WeatherFragment
 */
public interface WeatherResourceProvider {

    /**
     * Provide title String
     */
    String getTitle();

    /**
     * Provide Celsius String
     */
    String getCelsius();

    /**
     * Provide percents string
     */
    String getPercents();

    /**
     * Provide meters string
     */
    String getMeters();

    /**
     * Provide m/s string
     */
    String getMetersPerSecond();

    /**
     * Provide humidity string
     */
    String getHumidity();

    /**
     * Provide pressure string
     */
    String getPressure();

    /**
     * Provide wind speed string
     */
    String getWindSpeed();

    /**
     * Provide sunrise string
     */
    String getSunrise();

    /**
     * Provide sunset string
     */
    String getSunset();

    /**
     * Provide visibility string
     */
    String getVisibility();

    /**
     * Provide unknown string
     */
    String getUnknown();
}
