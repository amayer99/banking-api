package com.cgi.banking.bankingapi.Beans;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO {
    private Long transactionId;
    private Long amount;
    private Date date;
}
