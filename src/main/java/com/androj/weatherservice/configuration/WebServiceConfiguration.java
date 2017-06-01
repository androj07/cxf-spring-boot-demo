package com.androj.weatherservice.configuration;

import com.androj.weatherservice.endpoint.WeatherServiceEndpoint;
import de.codecentric.namespace.weatherservice.WeatherService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by andrzejhankus on 31/05/2017.
 */
@Configuration
public class WebServiceConfiguration {

    @Value("${cxf.path}")
    private String rootPath;

    @Value("${webservices.weatherservice.path}")
    private String servicePath;

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
        endpoint.publish(rootPath+servicePath);
        return endpoint;
    }
}
