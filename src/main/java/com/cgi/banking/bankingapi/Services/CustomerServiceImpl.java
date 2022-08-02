package com.cgi.banking.bankingapi.Services;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.banking.bankingapi.Beans.Customer;


import com.cgi.banking.bankingapi.Repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired CustomerRepository customerRepository;

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

    @Override
    public Customer getCustomerById(Long id){
        Optional<Customer> result = customerRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new EntityNotFoundException(String.valueOf(id));
        }
    }
    
}
