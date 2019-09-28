package com.t1708m.asm.config;

import com.t1708m.asm.entity.Account;
import com.t1708m.asm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountService.getByEmail(email);
        if (account == null){
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .build();
    }
}
