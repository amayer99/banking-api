package com.cgi.banking.bankingapi.Payload;

import java.util.Set;

import com.cgi.banking.bankingapi.Beans.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String stateAbbr;
    private String zipCode;
    private String phoneNumber;
    private Set<Account> accounts;
}
