package com.fdmgroup.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.model.Account;
import com.fdmgroup.model.AccountDTO;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.CustomerDTO;
import com.fdmgroup.service.CustomerService;

@RestController
@RequestMapping ("api/v1/customers")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping()
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById( @PathVariable long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {
		customerDTO.setAccounts(customerDTO.getAccountDTOs());
		Customer addedCustomer = customerService.addCustomer(customerDTO);
		
		URI newLocation=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addedCustomer.getCustomerId()).toUri();
		
		return ResponseEntity.created(newLocation).body(addedCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	    customerService.deleteCustomerById(id);
	    return ResponseEntity.noContent().build(); 
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
	    Customer updatedCustomer = customerService.updateCustomerById(id, customerDTO);
	    return ResponseEntity.ok(updatedCustomer); 
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccountById ( @PathVariable long id) {
		return customerService.findAccountById(id);
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<Customer> addAccounts(@PathVariable Long id, @RequestBody List<AccountDTO> accountDTOs) {
		Customer updatedCustomer = customerService.addAccounts(id, accountDTOs);
	    return ResponseEntity.ok(updatedCustomer); 
	}
	
	@PutMapping("/single-account/{id}")
	public ResponseEntity<Customer> addSingleAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
		Customer updatedCustomer = customerService.addSingleAccount(id, accountDTO);
	    return ResponseEntity.ok(updatedCustomer); 
	}
	
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
	    customerService.deleteAccountById(id);
	    return ResponseEntity.noContent().build(); 
	}
	
	@PutMapping("/update-account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
	    Account updatedAccount = customerService.updateAccountById(id, accountDTO);
	    return ResponseEntity.ok(updatedAccount); 
	}

}
