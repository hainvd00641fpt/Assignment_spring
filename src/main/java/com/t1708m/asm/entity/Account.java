package com.t1708m.asm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
    @Id
    @Email(message = "email không đúng định dạng!")
    private String email;
    @NotNull(message = "Không được để trống")
    private String password;
    @NotNull(message = "Không được để trống")
    private String name;
    @Size(max = 7, min = 7, message = "Mã sinh viên phải có độ dài 7 kí tự.")
    private String stuCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }
}
