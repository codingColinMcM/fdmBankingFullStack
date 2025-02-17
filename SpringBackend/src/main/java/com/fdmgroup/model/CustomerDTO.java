package com.fdmgroup.model;

import java.util.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CustomerDTO {
	
	private String name;
	private Address address;
	private String customerType;
	private List<Account> accounts;
	
	@JsonProperty("accountDTOs")
	private List<AccountDTO> accountDTOs;

	public CustomerDTO(String name, Address address, String customerType, List<AccountDTO> accountDTOs) {
		this.name = name;
		this.address = address;
		this.customerType = customerType;
		this.accounts = new ArrayList<>();
		for (AccountDTO accountDTO: accountDTOs) {
			this.accounts.add(AccountFactory.getChildAccount(accountDTO));
		}
	}

	public CustomerDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accountDTOs) {
		this.accounts = new ArrayList<>();
		for (AccountDTO accountDTO: accountDTOs) {
			this.accounts.add(AccountFactory.getChildAccount(accountDTO));
		}
	}
	
	public void addAccount(AccountDTO accountDTO) {
		this.accounts.add(AccountFactory.getChildAccount(accountDTO));
	}

	public List<AccountDTO> getAccountDTOs() {
		return accountDTOs;
	}

	public void setAccountDTOs(List<AccountDTO> accountDTOs) {
		this.accountDTOs = accountDTOs;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", address=" + address + ", customerType=" + customerType
				+ ", accounts=" + accountDTOs + "]";
	}
	
}
