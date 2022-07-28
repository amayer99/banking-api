package com.cgi.banking.bankingapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.banking.bankingapi.Beans.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    
}
