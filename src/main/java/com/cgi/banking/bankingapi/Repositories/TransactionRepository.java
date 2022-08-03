package com.cgi.banking.bankingapi.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.banking.bankingapi.Beans.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    
}
