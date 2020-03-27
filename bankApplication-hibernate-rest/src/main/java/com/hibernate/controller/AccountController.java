package com.hibernate.controller;

import com.hibernate.dao.AccountDao;
import com.hibernate.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao dao;

    @PutMapping("/credit/{accountNumber}")
    public String creditAccount(@PathVariable long accountNumber,@RequestParam(value = "amount") double amount){
        return dao.creditAccount(accountNumber,amount);
    }

    @PutMapping("/debit/{accountNumber}")
    public String debitAccount(@PathVariable long accountNumber,@RequestParam(value = "amount") double amount){
        return dao.debitAccount(accountNumber,amount);
    }

    @GetMapping("/{customerId}")
    public Account getAccountDetails(@PathVariable int customerId)
    {
        return dao.getAccountDetails(customerId);
    }

    @DeleteMapping("/{accountNumber}")
    public void deleteAccount(@PathVariable Long accountNumber)
    {
        dao.deleteAccount(accountNumber);
    }
}
