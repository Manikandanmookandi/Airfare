package com.fare.airfare.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import com.fare.airfare.authenticate.configureAuthentication;


@Service
public class AirFareBusinessServiceImpl implements AirfareBusinessService{
	
	@Autowired
	private configureAuthentication configAuth;

	public String retrieveAirportDetails() throws InterruptedException {
		
		RestTemplate rest=configAuth.oAuthRestTemplate();
		
		ResponseEntity<String> response
		  = rest.getForEntity("http://localhost:8080/airports", String.class);
		
		if (response.getStatusCode().equals(HttpStatus.OK))
			return response.getBody();			
		else
			return response.getStatusCode().toString();
				
		
		 
	}

	
	public String RetrieveAirFare(Map<String, String> requestHeader, Map<String, String> requestParam, String origin,
			String destination) throws InterruptedException {
		
		RestTemplate rest=configAuth.oAuthRestTemplate();		
		ResponseEntity<String> response
		  = rest.getForEntity("/fares/{origin_code}/{destination_code}", String.class);
		if (response.getStatusCode().equals(HttpStatus.OK))
			return response.getBody();			
		else
			return response.getStatusCode().toString();
	}

}
