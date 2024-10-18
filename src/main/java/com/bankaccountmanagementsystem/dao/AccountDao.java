package com.bankaccountmanagementsystem.dao;

import java.util.List;

import com.bankaccountmanagementsystem.entity.Account;

public interface AccountDao {
    void addAccount(Account account);
    Account getAccountById (Long id);
    List<Account> getAllAccounts();
    void deleteAccount(Long accountId);
	void withdraw(Long accountId, double amount);
	void deposit(Long accountId, double amount);
	

}
