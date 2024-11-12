package com.bankapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.entity.Account;
import com.bankapplication.repo.AccountRepo;
@Service
public class AccountServiceImple implements AccountService {
    
	@Autowired
	AccountRepo repo;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Account account_saved=repo.save(account);
		return account_saved;
	}

	@Override
	public Account getDetails(Long accountNumber) {
		// TODO Auto-generated method stub
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found=account.get();
		return account_found;
		
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccounts =repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent=account.get();
		Double totalBalance =accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		//Optional<Account> account=repo.findById(accountNumber);
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent=account.get();
		
		Double balance =accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(balance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getDetails(accountNumber);
		repo.deleteById(accountNumber);
	}

}
