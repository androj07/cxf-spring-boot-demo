package com.androj.weatherservice.endpoint;

import com.androj.weatherservice.business.WeatherInfoSupplier;
import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import de.codecentric.namespace.weatherservice.general.WeatherReturn;

/**
 * Created by andrzejhankus on 31/05/2017.
 */
public class WeatherServiceEndpoint implements WeatherService {

    private WeatherInfoSupplier weatherInfoSupplier;

    public WeatherServiceEndpoint(WeatherInfoSupplier weatherInfoSupplier) {
        this.weatherInfoSupplier = weatherInfoSupplier;
    }

    @Override
    public WeatherInformationReturn getWeatherInformation(String zip) throws WeatherException {
        final WeatherInformationReturn response = new WeatherInformationReturn();
        response.setResponseText(weatherInfoSupplier.getWeatherDescriptionForZipCode(zip));
        return response;
    }

    @Override
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return new ForecastReturn();
    }

    @Override
    public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return new WeatherReturn();
    }
}
