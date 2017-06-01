package com.androj.weatherservice.endpoint;

import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
properties = {"server.port=8181"})
public class WeatherServiceEndpointIntegrationTests {

	@Autowired
	@Qualifier("weatherServiceTestClient")
	private WeatherService cut;

	@Test
	public void testGetWeatherInformation() throws WeatherException {
		//given
		String zip = "99999";
		//when
		final WeatherInformationReturn response = cut.getWeatherInformation(zip);
		//then
		assertNotNull(response);
	}

}
