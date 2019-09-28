package com.t1708m.asm.service;

import com.t1708m.asm.entity.Account;
import com.t1708m.asm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<Account> getList(int page, int limit) {
        return accountRepository.findAll(PageRequest.of(page - 1, limit));
    }

    @Override
    public Account getDetail(String email) {
        return accountRepository.findById(email).orElse(null);
    }

    @Override
    public Account register(Account account) {
        //thuc hien ma hoa
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public Account login(String email, String password) {
        Optional<Account> optionalAccount = accountRepository.findById(email);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }


    @Override
    public Account getByEmail(String email) {
        return accountRepository.findById(email).orElse(null);
    }
}