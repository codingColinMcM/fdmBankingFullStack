package com.fdmgroup.model;

public class Standard {
	
	private String prov;
	private String city;
	
	public Standard(String prov, String city) {
		this.prov = prov;
		this.city = city;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Standard [prov=" + prov + ", city=" + city + "]";
	}

}
