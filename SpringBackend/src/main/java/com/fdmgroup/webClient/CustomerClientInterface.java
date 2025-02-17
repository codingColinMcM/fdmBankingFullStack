package com.fdmgroup.webClient;

import com.fdmgroup.model.Geocoder;

public interface CustomerClientInterface {

	public Geocoder getGeocoder(String postalCode);
	
}