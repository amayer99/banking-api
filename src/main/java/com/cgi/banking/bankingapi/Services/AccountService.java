package com.cgi.banking.bankingapi.Services;

import java.util.List;

import com.cgi.banking.bankingapi.Beans.Account;


public interface AccountService {
    public abstract Account createAccount(Account account);
    public abstract Account updateAccount(Long id, Account accountRequest);
    public abstract void deleteAccount(Long id);
    public abstract List<Account> getAllAccounts();
    public abstract Account getAccountById(long id);
}
