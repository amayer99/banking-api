package com.cgi.banking.bankingapi.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.banking.bankingapi.Services.AccountServiceImpl;
import com.cgi.banking.bankingapi.Beans.Account;
import com.cgi.banking.bankingapi.Payload.AccountDTO;
import com.cgi.banking.bankingapi.Payload.ApiResponse;

@RestController
@RequestMapping("/api/v1/accounts")

public class AccountController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/getAllAccounts")
    public List<AccountDTO> getAllAccounts(){
        return accountService.getAllAccounts().stream().map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable(name="id")Long id){
        Account account = accountService.getAccountById(id);

        AccountDTO accountResponse = modelMapper.map(account, AccountDTO.class);

        return ResponseEntity.ok().body(accountResponse);
    }


    /*not currently functional*/
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        
        Account accountRequest = modelMapper.map(accountDTO, Account.class);
        Account account = accountService.createAccount(accountRequest);

        AccountDTO accountResponse = modelMapper.map(account, AccountDTO.class);

        return new ResponseEntity<AccountDTO>(accountResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable long id, @RequestBody AccountDTO accountDTO){
        
        Account accountRequest = modelMapper.map(accountDTO, Account.class);
        Account account = accountService.updateAccount(id, accountRequest);

        AccountDTO accountResponse = modelMapper.map(account, AccountDTO.class);
        
        return ResponseEntity.ok().body(accountResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAccount(@PathVariable(name="id") Long id){
        accountService.deleteAccount(id);
        ApiResponse apiResponse = new ApiResponse();
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
    
}
