package com.fdmgroup.model;

import jakarta.persistence.*;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private long addressId;
	private String streetNumber;
	private String city;
	private String province;
	private String postalCode;
	
	
	public Address(String streetNumber, String city, String province, String postalCode) {
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}
	
	public Address(String streetNumber, String postalCode) {
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
	}

	public Address() {
		
	}
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
