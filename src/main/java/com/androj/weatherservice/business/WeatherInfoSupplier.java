package com.androj.weatherservice.business;

/**
 * Created by andrzejhankus on 02/06/2017.
 */
public interface WeatherInfoSupplier {
    String getWeatherDescriptionForZipCode(String zipCode);
}
