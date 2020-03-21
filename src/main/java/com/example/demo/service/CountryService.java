package com.example.demo.service;

import java.io.InputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.*;
import com.google.gson.Gson;

import elemental.json.JsonArray;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

@Service
public class CountryService implements ICountryService {

	private final RestTemplate restTemplate;

	public CountryService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<Country> getFilters(String countryCode, Filters filterObj) {
		StringBuilder strBuilder = new StringBuilder("http://api.worldbank.org/v2/country/");
		strBuilder.append(countryCode);
		strBuilder.append("?format=json");
		HttpHeaders headers = new HttpHeaders();
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// build the request
		/*
		 * HttpEntity request = new HttpEntity(headers); Response initialResponse =
		 * RestAssured.with().relaxedHTTPSValidation().when().
		 * get(strBuilder.toString()).thenReturn();
		 * 
		 * String asString = initialResponse.body().asString(); Gson gson = new Gson();
		 * ResponseObject entity = gson.fromJson((Reader) initialResponse.body(),
		 * ResponseObject.class);
		 */
		
		
		Response initialResponse = RestAssured.with().relaxedHTTPSValidation().when().
				  get(strBuilder.toString()).thenReturn();
		//JsonPath body = initialResponse.getBody().jsonPath();
		String asString = initialResponse.body().asString();
		JSONParser jsonParser = new JSONParser(asString);

		
		// use `exchange` method for HTTP call
		/*
		 * ResponseEntity<ResponseObject> response =
		 * this.restTemplate.exchange(strBuilder.toString(), HttpMethod.GET, request,
		 * ResponseObject.class, 1); getcountrynames(response.getBody(), filterObj);
		 */
		return null;
	}

	public String getcountrynames(ResponseObject ResponseObject, Filters filterObjectBoolean) {
		StringBuilder strBuilder = new StringBuilder("http://api.worldbank.org/V2/country?");
		if (filterObjectBoolean.getIncomeLevel() != null) {
			strBuilder.append("&incomelevel=");
			strBuilder.append(ResponseObject.getIncomeLevel().getValue());

		}
		if (filterObjectBoolean.getMatchRegion() != null) {
			strBuilder.append("&region=");
			strBuilder.append(ResponseObject.getRegion().getValue());

		}
		if (filterObjectBoolean.getLendingType() != null) {
			strBuilder.append("&lendingtype=");
			strBuilder.append(ResponseObject.getLendingType().getValue());

		}
		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// set custom header
		headers.set("x-request-source", "desktop");

		// build the request
		HttpEntity request = new HttpEntity(headers);

		// use `exchange` method for HTTP call
		ResponseEntity<List<ResponseObject>> response = this.restTemplate.exchange(strBuilder.toString(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<ResponseObject>>() {
				});
		if (response.getStatusCode() == HttpStatus.OK) {
			List<com.example.demo.model.ResponseObject> body = response.getBody();
			return body.get(0).getName();
		} else {
			return null;
		}
	}

}
