package com.cgi.banking.bankingapi.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.banking.bankingapi.Beans.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
