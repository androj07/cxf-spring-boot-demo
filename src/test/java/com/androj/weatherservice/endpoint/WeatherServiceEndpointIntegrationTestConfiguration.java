package com.androj.weatherservice.endpoint;

import de.codecentric.namespace.weatherservice.WeatherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by andrzejhankus on 01/06/2017.
 */
@Configuration
public class WeatherServiceEndpointIntegrationTestConfiguration {

    @Value("${server.port}")
    private String port;

    @Value("${cxf.path}")
    private String rootPath;

    @Value("${webservices.weatherservice.path}")
    private String servicePath;

    @Bean
    public WeatherService weatherServiceTestClient(){
        JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(WeatherService.class);
        jaxWsProxyFactory.setAddress("http://localhost:"+port+rootPath+servicePath);
        return (WeatherService) jaxWsProxyFactory.create();
    }
}
