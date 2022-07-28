package com.cgi.banking.bankingapi.Services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.banking.bankingapi.Beans.Customer;
import com.cgi.banking.bankingapi.Beans.CustomerDTO;


import com.cgi.banking.bankingapi.Beans.Customer;
import com.cgi.banking.bankingapi.Beans.CustomerDTO;
import com.cgi.banking.bankingapi.Repositories.CustomerRepository;
import com.cgi.banking.bankingapi.Repositories.CustomerRepository;


public class CustomerServiceImpl implements CustomerService{

    @Autowired CustomerRepository customerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public Customer updateCustomer(Long id, Customer customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
        
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setStreetAddress(customerRequest.getStreetAddress());
        customer.setCity(customerRequest.getCity());
        customer.setStateAbbr(customerRequest.getStateAbbr());
        customer.setZipCode(customerRequest.getZipCode());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
    
        return customerRepository.save(customer);

    }
    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
        customerRepository.delete(customer);

        
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
}
