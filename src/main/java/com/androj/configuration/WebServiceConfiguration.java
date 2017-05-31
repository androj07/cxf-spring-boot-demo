package com.androj.configuration;

import com.androj.weatherservice.endpoint.WeatherServiceEndpoint;
import de.codecentric.namespace.weatherservice.WeatherService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by andrzejhankus on 31/05/2017.
 */
@Configuration
public class WebServiceConfiguration {

    @Bean
    public WeatherService weatherService(){
        return new WeatherServiceEndpoint();
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(springBus(), weatherService());
        endpoint.publish("/WeatherSoapService_1.0");
        endpoint.setWsdlLocation("Weather1.0.wsdl");
        return endpoint;
    }
}
