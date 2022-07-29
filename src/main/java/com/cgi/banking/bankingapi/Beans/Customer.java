package com.cgi.banking.bankingapi.Beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Customer{
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name="firstName",nullable=false, length=50)
    private String firstName;

    @Column(name="lastName",nullable=false, length=50)
    private String lastName;

    @Column(name="streetAddress", length=95)
    private String streetAddress;

    @Column(name="city", length=35)
    private String city;

    @Column(name="stateAbbr", length=2)
    private String stateAbbr;

    @Column(name="zipCode", length=5)
    private String zipCode;

    @Column(name="phoneNumber", length=10)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cid")
    private Set<Account> accounts;
    
}