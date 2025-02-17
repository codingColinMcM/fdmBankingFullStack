package com.fdmgroup.model;

public class AccountFactory {
	
	public static Account getChildAccount(AccountDTO accountDTO) {
		
		Account account = null;
		
		if (accountDTO.getAccountType().equalsIgnoreCase("SAVINGSACCOUNT"))
			account = new SavingsAccount(accountDTO.getBalance(), accountDTO.getCustomer(), accountDTO.getInterestRate());
		if (accountDTO.getAccountType().equalsIgnoreCase("CHECKINGACCOUNT"))
			account = new CheckingAccount(accountDTO.getBalance(), accountDTO.getCustomer(), accountDTO.getNextCheckNumber());
		
		return account;
		
	}

}
