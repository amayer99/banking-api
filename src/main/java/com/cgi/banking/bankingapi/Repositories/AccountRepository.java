package com.cgi.banking.bankingapi.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.banking.bankingapi.Beans.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
