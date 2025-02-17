package com.fdmgroup.model;

import org.springframework.stereotype.Component;

@Component
public class AccountDTO {
	
	private double balance;
	private Customer customer;
	private double interestRate;
	private int nextCheckNumber;
	private String accountType;
	
	public AccountDTO(double balance, Customer customer, double interestRate, int nextCheckNumber, String accountType) {
		this.balance = balance;
		this.customer = customer;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
		this.accountType = accountType;
	}
	
	public AccountDTO() {
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "AccountDTO [balance=" + balance + ", customer=" + customer
				+ ", interestRate=" + interestRate + ", nextCheckNumber=" + nextCheckNumber + "]";
	}

}
