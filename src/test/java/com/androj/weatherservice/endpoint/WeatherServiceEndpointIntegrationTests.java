package com.androj.weatherservice.endpoint;

import com.androj.weatherservice.business.WeatherInfoSupplier;
import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
properties = {"server.port=8181"})
public class WeatherServiceEndpointIntegrationTests {

	@Autowired
	@Qualifier("weatherServiceTestClient")
	private WeatherService cut;

	@MockBean
	private WeatherInfoSupplier mockedWeatherInfoSupplier;

	@Test
	public void testGetWeatherInformation() throws WeatherException {
		//given
		String zip = "99999";
		String expectedDescription = "It will be sunny day";
		when(mockedWeatherInfoSupplier.getWeatherDescriptionForZipCode(anyString())).thenReturn(expectedDescription);
		//when
		final WeatherInformationReturn response = cut.getWeatherInformation(zip);
		//then
		assertNotNull(response);
		assertThat(response.getResponseText(),is(equalTo(expectedDescription)));
	}

}
