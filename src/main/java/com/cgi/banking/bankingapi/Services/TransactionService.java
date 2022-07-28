package com.cgi.banking.bankingapi.Services;

import java.util.List;

import com.cgi.banking.bankingapi.Beans.Transaction;


public interface TransactionService {
    public abstract Transaction createTransaction(Transaction transaction);
    public abstract void updateTransaction(Long id, Transaction transaction);
    public abstract void deleteTransaction(Long id);
    public abstract List<Transaction> getAllTransactions();
}
