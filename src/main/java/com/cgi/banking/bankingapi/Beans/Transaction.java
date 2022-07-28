package com.cgi.banking.bankingapi.Beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sendCustomerId", nullable = false)
    private Customer sendCustomer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recieveCustomerId", nullable = false)
    private Customer recieveCustomer;
}