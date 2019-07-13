package com.sapient.footballasses.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.sapient.footballasses.service.impl.FootBallAssesmentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class FootBallAssesmentServiceImplTest {
	
	FootBallAssesmentServiceImpl service;
	@Before
	public void setUp() {
		service = new FootBallAssesmentServiceImpl();
		ReflectionTestUtils.setField(service, "apiUrl", "https://apiv2.apifootball.com");
	}
	@Test
	public void getCountries() throws Exception {
		String countriesList = service.getCountries("get_countries","9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		Assertions.assertThat(countriesList).contains("USA");
	}
	@Test
	public void getCountries_api_key_null() throws Exception {
		String response = service.getCountries("get_countries",null);
		Assertions.assertThat(response).contains("Authentification failed");
	}
}
