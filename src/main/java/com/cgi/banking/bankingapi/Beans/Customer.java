package com.cgi.banking.bankingapi.Beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable=false, length=95)
    private String streetAddress;

    @Column(nullable=false, length=35)
    private String city;

    @Column(nullable=false, length=2)
    private String stateAbbr;

    @Column(nullable=false, length=5)
    private String zipCode;

    @Column(nullable=false, length=10)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private Set<Account> accounts;
}