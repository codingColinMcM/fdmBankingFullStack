package com.fdmgroup.model;

public class Geocoder {
	
	private Standard standard;

	public Geocoder(Standard standard) {
		this.standard = standard;
	}

	public Geocoder() {
	
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Geocoder [standard=" + standard + "]";
	} 

}
