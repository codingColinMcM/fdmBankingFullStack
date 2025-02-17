package com.fdmgroup.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.model.Account;
import com.fdmgroup.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	AccountRepository accountRepository;
	
	public AccountServiceImplementation(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

}
