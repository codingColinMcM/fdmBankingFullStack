package com.fdmgroup.model;

public class CustomerFactory {
	
	public static Customer getChildCustomer(CustomerDTO customerDTO) {
		
		Customer customer = null;
		
		if (customerDTO.getCustomerType().equalsIgnoreCase("COMPANY"))
			customer = new Company(customerDTO.getName(), customerDTO.getAddress(), customerDTO.getAccounts());
		if (customerDTO.getCustomerType().equalsIgnoreCase("PERSON"))
			customer = new Person(customerDTO.getName(), customerDTO.getAddress(), customerDTO.getAccounts());
		
		return customer;
		
	}

}
