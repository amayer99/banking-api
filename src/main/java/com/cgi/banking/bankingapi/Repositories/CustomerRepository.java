package com.cgi.banking.bankingapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.banking.bankingapi.Beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}
