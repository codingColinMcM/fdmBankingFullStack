package com.fdmgroup.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.exceptions.CustomerNotFoundException;
import com.fdmgroup.exceptions.AccountNotFoundException;
import com.fdmgroup.model.Account;
import com.fdmgroup.model.AccountDTO;
import com.fdmgroup.model.AccountFactory;
import com.fdmgroup.model.CheckingAccount;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.CustomerDTO;
import com.fdmgroup.model.CustomerFactory;
import com.fdmgroup.model.Geocoder;
import com.fdmgroup.model.Person;
import com.fdmgroup.model.SavingsAccount;
import com.fdmgroup.repository.CustomerRepository;
import com.fdmgroup.repository.AccountRepository;
import com.fdmgroup.webClient.CustomerClientInterface;

@Service
public class CustomerServiceImplementation implements CustomerService {

	CustomerRepository customerRepository;
	CustomerClientInterface customerClientInterface;
	AccountRepository accountRepository;
	
	@Autowired
	public CustomerServiceImplementation(CustomerRepository customerRepository, CustomerClientInterface customerClientInterface, AccountRepository accountRepository) {
		this.customerRepository = customerRepository;
		this.customerClientInterface = customerClientInterface;
		this.accountRepository = accountRepository;
	}
	
	public Customer getCityAndProvince(Customer customer) {
		Geocoder geocoder = customerClientInterface.getGeocoder(customer.getAddress().getPostalCode());
		customer.getAddress().setCity(geocoder.getStandard().getCity());
		customer.getAddress().setProvince(geocoder.getStandard().getProv());
		return customer;
	}
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = CustomerFactory.getChildCustomer(customerDTO);
		customer = getCityAndProvince(customer);
		for(Account account: customer.getAccounts()) {
			account.setCustomer(customer);
		}
		customerRepository.save(customer);
		
		for(Account account: customer.getAccounts()) {
			accountRepository.save(account);
		}
		
		return customer;
	}

	@Override
	public Customer findCustomerById(long id) {
		return customerRepository.findById(id)
				.orElseThrow(()->new CustomerNotFoundException("No account found with the id: " + id));
	}

	@Override
	public Customer updateCustomerById(long id, CustomerDTO customerDTO) {
		Customer existingCustomer = customerRepository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));

        existingCustomer.setName(customerDTO.getName());
        existingCustomer.getAddress().setStreetNumber(customerDTO.getAddress().getStreetNumber());
        existingCustomer.getAddress().setPostalCode(customerDTO.getAddress().getPostalCode());
        
        existingCustomer = getCityAndProvince(existingCustomer);

        return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomerById(long id) {
		Customer existingCustomer = customerRepository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
		for (Account account: existingCustomer.getAccounts()) {
			accountRepository.deleteById(account.getAccountId());
		}
        customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	//TODO: Move this business logic to AccountService
	
	@Override
	public Account findAccountById(long id) {
		return accountRepository.findById(id)
				.orElseThrow(()->new AccountNotFoundException("No account found with the id: " + id));
	}
	

	@Override
	public Customer addAccounts(Long id, List<AccountDTO> accountDTOs) {
		Customer existingCustomer = customerRepository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
	   

		for (AccountDTO accountDTO: accountDTOs) {
			Account account = AccountFactory.getChildAccount(accountDTO);
			account.setCustomer(existingCustomer);
			existingCustomer.addAccount(account);
			accountRepository.save(account);
		}
		
		return customerRepository.save(existingCustomer);
	}

	@Override
	public Customer addSingleAccount(Long id, AccountDTO accountDTO) {
		Customer existingCustomer = customerRepository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
		
		Account account = AccountFactory.getChildAccount(accountDTO);
		account.setCustomer(existingCustomer);
		existingCustomer.addAccount(account);
		accountRepository.save(account);
		
		return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteAccountById(long id) {
		Account existingAccount = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id:" + id));
		
		
		
		accountRepository.deleteById(existingAccount.getAccountId());
	}

	@Override
	public Account updateAccountById(long id, AccountDTO accountDTO) {
		Account existingAccount = accountRepository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));

		
        existingAccount.setBalance(accountDTO.getBalance());
        
        if (accountDTO.getAccountType().equalsIgnoreCase("SAVINGSACCOUNT"))
        	((SavingsAccount)existingAccount).setInterestRate(accountDTO.getInterestRate());

    	if (accountDTO.getAccountType().equalsIgnoreCase("CHECKINGACCOUNT"))
    		((CheckingAccount)existingAccount).setNextCheckNumber(accountDTO.getNextCheckNumber());
       

        return accountRepository.save(existingAccount);

	}
	

}
