package com.apple.avinash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apple.avinash.beans.Continent;

@Service
public interface FlagPickerService {
	
	 List<Continent>  getContinentResponseAll(String continentName,String countryName) throws Exception;

}
