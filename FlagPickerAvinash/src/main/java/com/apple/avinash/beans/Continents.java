package com.apple.avinash.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Continents {
	private List<Continent> continents;

	public List<Continent> getContinents() {
		return continents;
	}

	public void setContinents(List<Continent> continents) {
		this.continents = continents;
	}

	@Override
	public String toString() {
		return "Continents [continents=" + continents + "]";
	}

		
}
