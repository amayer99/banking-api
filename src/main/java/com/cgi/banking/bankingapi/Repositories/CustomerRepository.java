package com.cgi.banking.bankingapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.banking.bankingapi.Beans.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}
