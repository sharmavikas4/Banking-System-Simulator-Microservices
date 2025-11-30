package com.service;

import com.model.Account;
import com.model.dto.AccountCreateRequest;
import com.model.dto.AccountStatusUpdateRequest;
import com.model.dto.BalanceUpdateRequest;

public interface AccountServiceInterface {
	
	Account getAccountByAccountNumber(String accountNumber);
	
	Account createAccount(AccountCreateRequest accountCreateRequest);
	
	Account updateAccountBalance(String accountNumber,BalanceUpdateRequest balanceUpdateRequest);
	
	Account updateAccountStatus(String accountNumber,AccountStatusUpdateRequest accountStatusUpdateRequest);
}
