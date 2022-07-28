package com.cgi.banking.bankingapi.Services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.banking.bankingapi.Beans.Account;
import com.cgi.banking.bankingapi.Repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account accountRequest) {
        Account account = accountRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
        account.setAccountType(accountRequest.getAccountType());
        account.setCurrentBalance(accountRequest.getCurrentBalance());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
       Account account = accountRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
       accountRepository.delete(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(long id){
        Optional<Account> result = accountRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new EntityNotFoundException(String.valueOf(id));
        }
    }
    
}
