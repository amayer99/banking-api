package com.cgi.banking.bankingapi.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO {
    private Long accountId;
    private String accountType;
    private Long currentBalance;
}
