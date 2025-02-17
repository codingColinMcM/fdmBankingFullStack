package com.fdmgroup.model;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {
	
	private int nextCheckNumber;

	public CheckingAccount( double balance, Customer customer, int nextCheckNumber) {
		super(balance, customer);
		this.nextCheckNumber = nextCheckNumber;
	}
	
	public CheckingAccount() {
		super();
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + "]";
	}

}
