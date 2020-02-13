package com.apple.avinash.beans;

import java.util.Arrays;

public class Continent {
	private String continent;
	private Country[] countries;
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Country[] getCountries() {
		return countries;
	}
	public void setCountries(Country[] countries) {
		this.countries = countries;
	}
	@Override
	public String toString() {
		return "Continent [continent=" + continent + ", countries=" + Arrays.toString(countries) + "]";
	}
	

}
