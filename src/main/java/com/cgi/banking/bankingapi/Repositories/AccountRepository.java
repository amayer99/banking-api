package com.cgi.banking.bankingapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
