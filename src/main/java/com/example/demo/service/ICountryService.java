package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Country;
import com.example.demo.model.Filters;
import com.example.demo.model.ResponseObject;

public interface ICountryService {
	 String getcountrynames(ResponseObject responseObject, Filters filterObjectBoolean);
	 List<Country> getFilters(String countryCode,Filters filterObj);
}
