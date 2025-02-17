package com.fdmgroup.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Company")
public class Company extends Customer {

	public Company() {
		super();
	}

	public Company(String name, Address address) {
		super(name, address);
	}

	public Company(String name, Address address, List<Account> accounts) {
		super(name, address, accounts);
	}
	
}
