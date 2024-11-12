package com.bankapplication.service;

import java.util.List;
import com.bankapplication.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	public Account getDetails(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber,Double amount);
	public Account withdrawAmount(Long account, Double amount);
	public void closeAccount(Long accountNumber);

}
