package com.cgi.banking.bankingapi.Beans;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @Column(name="account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name="accountType",nullable = false, length=10)
    private String accountType;

    @Column(name="currentBalance", nullable = false)
    private Long currentBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="cid")
    private Customer customer;


    @OneToMany
    @JoinColumn(name="sender")
    private Set<Transaction> sentTransactions;

 
    @OneToMany
    @JoinColumn(name="reciever")
    private Set<Transaction> recievedTransactions;

    
}