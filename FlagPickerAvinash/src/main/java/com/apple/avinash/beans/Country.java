package com.apple.avinash.beans;

public class Country {
	private String name;
	private String flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", flag=" + flag + "]";
	}
	
	
}
