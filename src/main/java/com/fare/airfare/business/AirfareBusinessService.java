package com.fare.airfare.business;

import java.util.List;

import java.util.Map;

import org.springframework.http.ResponseEntity;



public interface AirfareBusinessService {
	
	String retrieveAirportDetails() throws InterruptedException;
	
	// String RetrieveAirFare();
	String RetrieveAirFare(Map<String, String> requestHeader, Map<String, String> requestParam, String origin,
				String destination) throws InterruptedException;
		
	
	

}
