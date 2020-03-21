package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.*;
import com.example.demo.service.ICountryService;

@RestController
public class CountryController {

	@Autowired
	ICountryService countryService;

	@GetMapping("/countries/{countryCode}")
	ResponseEntity<List<Country>> one(@Valid @PathVariable(value = "countryCode") String countryName,
			@RequestParam(value = "incomeLevel", required = false) String incomeLevel,
			@RequestParam(value = "region", required = false) String region,
			@RequestParam(value = "lendingType", required = false) String lendingType) {
		Filters filterObj = new Filters();
		if (null != region && !region.isEmpty()) {
			filterObj.setMatchRegion(region);
		}
		if (null != lendingType && !lendingType.isEmpty()) {
			filterObj.setLendingType(lendingType);
		}
		if (null != incomeLevel && !incomeLevel.isEmpty()) {
			filterObj.setIncomeLevel(incomeLevel);
		}
		if (null != filterObj.getMatchRegion() || null != filterObj.getLendingType()
				|| null != filterObj.getIncomeLevel()) {
			List<Country> countries = countryService.getFilters(countryName, filterObj);
			return new ResponseEntity<List<Country>>(countries, HttpStatus.CREATED);
		} else {
			return new ResponseEntity("Bad Input", HttpStatus.BAD_REQUEST);
		}

	}

}
