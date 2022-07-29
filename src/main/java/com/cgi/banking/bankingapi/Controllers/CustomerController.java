package com.cgi.banking.bankingapi.Controllers;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cgi.banking.bankingapi.Beans.Customer;
import com.cgi.banking.bankingapi.Payload.CustomerDTO;
import com.cgi.banking.bankingapi.Services.CustomerServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping("/api/v1/customers")

public class CustomerController {
    @JsonIgnoreProperties
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers().stream().map(account -> modelMapper.map(account, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name="id")Long id){
        Customer customer = customerService.getCustomerById(id);

        CustomerDTO customerResponse = modelMapper.map(customer,CustomerDTO.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){

        Customer customerRequest=modelMapper.map(customerDTO, Customer.class);
        Customer customer = customerService.createCustomer(customerRequest);

        CustomerDTO customerResponse= modelMapper.map(customer, CustomerDTO.class);

        return new ResponseEntity<CustomerDTO>(customerResponse, HttpStatus.CREATED);    
    }
    
}
