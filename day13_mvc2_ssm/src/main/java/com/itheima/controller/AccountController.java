package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/queryAll")
    public String queryAll(){
/*
        System.out.println("AccountController");
*/
        List<Account> accounts = accountService.queryAll();
        System.out.println(accounts);
        return "list";
    }
}
