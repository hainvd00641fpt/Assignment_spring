package com.t1708m.asm.service;

import com.t1708m.asm.entity.Account;
import org.springframework.data.domain.Page;

public interface AccountService {
    Page<Account> getList(int page, int limit);

    Object getDetail(String email);

    //thuc hien xac thuc nguoi dung
    Account login(String email, String password);

    //Dang ki tai khoan, ma hoa mat khau
    Account register(Account account);


    Account getByEmail(String email);
}
