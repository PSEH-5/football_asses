package com.sapient.footballasses.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.footballasses.service.FootBallAssesmentService;
@Service
public class FootBallAssesmentServiceImpl implements FootBallAssesmentService {
	@Value("${url}")
	String apiUrl;

	@Override
	public String getCountries(String action, String apiKey) throws Exception{
		String url = apiUrl + "?action=" +action+"&APIkey="+apiKey;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity entity = new HttpEntity<>(requestHeaders);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		if(response.getStatusCode()!=HttpStatus.OK) {
			throw new Exception(response.getBody());
		}
		return response.getBody();
	}

}
