package com.androj.weatherservice.business;

/**
 * Created by andrzejhankus on 02/06/2017.
 */
public class DummyWeatherInfoStub implements WeatherInfoSupplier {
    @Override
    public String getWeatherDescriptionForZipCode(String zipCode) {
        return null;
    }
}
