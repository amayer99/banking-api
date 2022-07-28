package com.cgi.banking.bankingapi.Services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.banking.bankingapi.Beans.Transaction;
import com.cgi.banking.bankingapi.Repositories.TransactionRepository;

public class TransactionServiceImpl implements TransactionService{
    @Autowired TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    @Override
    public Transaction updateTransaction(Long id, Transaction transactionRequest) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));

        transaction.setAmount(transactionRequest.getAmount());
        transaction.setDate(transactionRequest.getDate());

        return transactionRepository.save(transaction);

    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
        transactionRepository.delete(transaction);

        
    }
    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    
}
