package com.cgi.banking.bankingapi.Services;

import java.util.List;

import com.cgi.banking.bankingapi.Beans.Customer;

public interface CustomerService {

    public abstract Customer createCustomer(Customer customer);
    public abstract Customer updateCustomer(Long id, Customer customer);
    public abstract void deleteCustomer(Long id);
    public abstract List<Customer> getAllCustomers();
    public abstract Customer getCustomerById(Long id);
    
}
