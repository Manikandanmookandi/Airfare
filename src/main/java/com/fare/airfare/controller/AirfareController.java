package com.fare.airfare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;

import com.fare.airfare.business.AirfareBusinessService;




@RestController
public class AirfareController {
	
@Autowired
private AirfareBusinessService airfareBusinessService;

	
	
	
	@RequestMapping(value = "/airports", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getAirportDetails()  throws InterruptedException{
		
		String AirportList = airfareBusinessService.retrieveAirportDetails();
		return new ResponseEntity<String>(AirportList, HttpStatus.OK);
		
			
		

	}
	
	@RequestMapping(value = "/fares/{origin}/{destination}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> calculateFare(@RequestHeader final Map<String, String> requestHeader,
			@RequestParam final Map<String, String> requestParam, @PathVariable("origin") String origin,
			@PathVariable("destination") String destination) throws InterruptedException {
		String fare = airfareBusinessService.RetrieveAirFare(requestHeader, requestParam,origin,destination);
		return new ResponseEntity<String>(fare, HttpStatus.OK);

	}

}
