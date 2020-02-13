package com.apple.avinash.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apple.avinash.beans.Continent;
import com.apple.avinash.beans.Country;
import com.apple.avinash.exception.FlagPickerRecordNotFoundException;
import com.apple.avinash.service.FlagPickerServiceImpl;

@SpringBootTest
public class FlagPickerServiceImplTest {

	@Autowired
	FlagPickerServiceImpl flagPickerServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	public void filterAll() throws Exception {

		List<Continent> continentsMock = mockContinents();
		List<Continent> continentsReturn = flagPickerServiceImpl.filter(continentsMock, null, null);
		assertEquals(continentsMock, continentsReturn);

	}

	// test case when we pass country name success
	@Test
	public void filterCountryNameSuccess() throws Exception {

		List<Continent> continentsMock = mockContinents();
		List<Continent> continentsReturn = flagPickerServiceImpl.filter(continentsMock, null, "USA");

		assertEquals(1, continentsReturn.size());
		assertEquals("America", continentsReturn.get(0).getContinent());
		assertEquals(1, continentsReturn.get(0).getCountries().length);
		assertEquals("USA", continentsReturn.get(0).getCountries()[0].getName());
		assertEquals("USAFlag", continentsReturn.get(0).getCountries()[0].getFlag());

	}

	// test case when we pass country name Fail
	@Test
	public void filterCountryNameFail() throws Exception {

		List<Continent> continentsMock = mockContinents();

		Assertions.assertThrows(FlagPickerRecordNotFoundException.class, () -> {
			flagPickerServiceImpl.filter(continentsMock, null, "USAA");
		});

	}

	// test case when we pass continent
	@Test
	public void filterContinentNameSuccess() throws Exception {

		List<Continent> continentsMock = mockContinents();
		List<Continent> continentsReturn = flagPickerServiceImpl.filter(continentsMock, "America", "");

		assertEquals(1, continentsReturn.size());
		assertEquals("America", continentsReturn.get(0).getContinent());
		assertEquals(2, continentsReturn.get(0).getCountries().length);
		assertEquals("USA", continentsReturn.get(0).getCountries()[0].getName());
		assertEquals("USAFlag", continentsReturn.get(0).getCountries()[0].getFlag());
		assertEquals("Brazil", continentsReturn.get(0).getCountries()[1].getName());
		assertEquals("BrazilFlag", continentsReturn.get(0).getCountries()[1].getFlag());

	}

	// test case when we pass country name Fail
	@Test
	public void ffilterContinentNameFail() throws Exception {

		List<Continent> continentsMock = mockContinents();

		Assertions.assertThrows(FlagPickerRecordNotFoundException.class, () -> {
			flagPickerServiceImpl.filter(continentsMock, "Americaa", null);
		});

	}

	private List<Continent> mockContinents() {
		List<Continent> continentsMock = new ArrayList<Continent>();
		Country[] countriesAdd1 = new Country[2];
		Country country11 = new Country();
		country11.setFlag("EthiopiaFlag");
		country11.setName("Ethiopia");
		Country country12 = new Country();
		country12.setFlag("EgyptFlag");
		country12.setName("Egypt");
		countriesAdd1[0] = country11;
		countriesAdd1[1] = country12;
		Continent continentAdd1 = new Continent();
		continentAdd1.setContinent("Africa");
		continentAdd1.setCountries(countriesAdd1);

		Country[] countriesAdd2 = new Country[2];
		Country country21 = new Country();
		country21.setFlag("USAFlag");
		country21.setName("USA");
		Country country22 = new Country();
		country22.setFlag("BrazilFlag");
		country22.setName("Brazil");
		countriesAdd2[0] = country21;
		countriesAdd2[1] = country22;
		Continent continentAdd2 = new Continent();
		continentAdd2.setContinent("America");
		continentAdd2.setCountries(countriesAdd2);

		continentsMock.add(continentAdd1);
		continentsMock.add(continentAdd2);
		return continentsMock;
	}

}
