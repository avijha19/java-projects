package com.apple.avinash.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apple.avinash.beans.Continent;
import com.apple.avinash.beans.Country;
import com.apple.avinash.exception.FlagPickerRecordNotFoundException;
import com.apple.avinash.exception.FlagPickerServiceException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FlagPickerServiceImpl implements FlagPickerService {

	private static final Logger logger = LoggerFactory.getLogger(FlagPickerServiceImpl.class);

	@Override
	public List<Continent> getContinentResponseAll(String continentName, String countryName) throws Exception {
		// create ObjectMapper instance
		logger.info("START: FlagPickerServiceImpl::getContinentResponseAll");
		ObjectMapper objectMapper = new ObjectMapper();

		List<Continent> continentsAll = null;
		List<Continent> continents = null;

		try {
			TypeReference<List<Continent>> typeRef = new TypeReference<List<Continent>>() {
			};
			continentsAll = objectMapper.readValue(new File("continents.json"), typeRef);
			logger.info("All Continents" + continentsAll);

			continents = filter(continentsAll, continentName, countryName);
		} catch (IOException e) {
			logger.error(" IO exception occured: ");
			FlagPickerServiceException serviceException = new FlagPickerServiceException();
			serviceException.setErrorCode("ERROR_IO_EXCEPTION");
			serviceException.setDisplayErrorMessage("Error message occured while reading continents.json");
		} catch (FlagPickerRecordNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		logger.info("END: getContinentResponseAll ");

		return continents;
	}

	public List<Continent> filter(List<Continent> continents, String continentName, String countryName)
			throws Exception {

		logger.info("START: FlagPickerServiceImpl::filter");

		List<Continent> continentsReturn = new ArrayList<Continent>();

		if (StringUtils.isEmpty(continentName) && StringUtils.isEmpty(countryName)) {
			continentsReturn = continents;
		} else if (!StringUtils.isEmpty(continentName) && StringUtils.isEmpty(countryName)) {
			for (Continent continent : continents) {
				if (continent.getContinent().equals(continentName)) {
					continentsReturn.add(continent);
				}
			}

			if (continentsReturn.isEmpty()) {
				FlagPickerRecordNotFoundException recordNotFoundException = new FlagPickerRecordNotFoundException();
				recordNotFoundException
						.setDisplayErrorMessage("There is no record found for given continent: " + continentName);
				recordNotFoundException.setErrorCode("RECORD_NOT_FOUND");
				throw recordNotFoundException;
			}

		} else if (StringUtils.isEmpty(continentName) && !StringUtils.isEmpty(countryName)) {
			Country countryAdd = null;
			Continent continentAdd = null;
			for (Continent continent : continents) {
				Country[] countries = continent.getCountries();
				for (Country country : countries) {
					if (country.getName().equals(countryName)) {
						countryAdd = country;
						continentAdd = new Continent();
						continentAdd.setContinent(continent.getContinent());
						Country[] countriesAdd = new Country[1];
						countriesAdd[0] = countryAdd;
						continentAdd.setCountries(countriesAdd);
					}
				}
			}
			if(continentAdd!=null) {
				continentsReturn.add(continentAdd);
			} else {
				FlagPickerRecordNotFoundException recordNotFoundException = new FlagPickerRecordNotFoundException();
				recordNotFoundException
						.setDisplayErrorMessage("There is no record found for given country: " + countryName);
				recordNotFoundException.setErrorCode("RECORD_NOT_FOUND");
				throw recordNotFoundException;
			}
		}
		logger.info("END: FlagPickerServiceImpl::filter");
		return continentsReturn;

	}

}
