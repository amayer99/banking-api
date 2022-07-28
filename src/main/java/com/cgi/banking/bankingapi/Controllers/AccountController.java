package com.cgi.banking.bankingapi.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.banking.bankingapi.Services.AccountService;
import com.cgi.banking.bankingapi.Beans.Account;
import com.cgi.banking.bankingapi.Beans.AccountDTO;

@RestController
@RequestMapping("/api/v1")

public class AccountController {
    @Autowired
    private ModelMapper modelMapper;

    private AccountService accountService;

    @GetMapping("/getAllAccounts")
    public List<AccountDTO> getAllAccounts(){
        return accountService.getAllAccounts().stream().map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getPostById(@PathVariable(name="id")Long id){
        Account account = accountService.getAccountById(id);

        AccountDTO accountResponse = modelMapper.map(account, AccountDTO.class);

        return ResponseEntity.ok().body(accountResponse);
    }
    
}
