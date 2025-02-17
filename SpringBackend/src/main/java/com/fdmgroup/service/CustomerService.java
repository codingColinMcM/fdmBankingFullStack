package com.fdmgroup.service;

import java.util.*;

import com.fdmgroup.model.*;

public interface CustomerService {
	
	public Customer addCustomer(CustomerDTO customerDTO);
	public Customer findCustomerById(long id);
	public Customer updateCustomerById(long id, CustomerDTO customerDTO);
	public void deleteCustomerById(long id);
	public List<Customer> findAll();
	public Account findAccountById(long id);
	public Customer addAccounts(Long id, List<AccountDTO> accountDTOs);
	public Customer addSingleAccount(Long id, AccountDTO accountDTO);
	public void deleteAccountById(long id);
	public Account updateAccountById(long id, AccountDTO accountDTO);

}
