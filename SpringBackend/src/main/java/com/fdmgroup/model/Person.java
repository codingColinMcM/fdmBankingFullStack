package com.fdmgroup.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Person")
public class Person extends Customer {

	public Person() {
		super();
	}

	public Person(String name, Address address) {
		super(name, address);
	}

	public Person(String name, Address address, List<Account> accounts) {
		super(name, address, accounts);
	}
	
}
