package com.fdmgroup.model;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
	
	private double interestRate;

	public SavingsAccount(double balance, Customer customer, double interestRate) {
		super(balance, customer);
		this.interestRate = interestRate;
	}

	public SavingsAccount() {
		super();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
	
	

}
