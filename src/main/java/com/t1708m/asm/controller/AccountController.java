package com.t1708m.asm.controller;

import com.t1708m.asm.entity.Account;
import com.t1708m.asm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage(){
        return "accounts/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showAccountList(Model model){
        model.addAttribute("list", accountService.getList(1, 10));
        return "accounts/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createAccount(Model model){
        model.addAttribute("account", new Account());
        return "accounts/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeAccount(@Valid Account account, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "accounts/form";
        }
        accountService.register(account);
        return "redirect:success";
    }
}
