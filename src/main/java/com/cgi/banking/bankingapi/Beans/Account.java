package com.cgi.banking.bankingapi.Beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, length=10)
    private String accountType;

    @Column(nullable = false)
    private Long currentBalance;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId", nullable = false) 
    private Customer customer;

    @OneToMany(mappedBy = "sendCustomer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Transaction> sentTransactions;

    @OneToMany(mappedBy = "recieveCustomer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Transaction> recievedTransactions;
}