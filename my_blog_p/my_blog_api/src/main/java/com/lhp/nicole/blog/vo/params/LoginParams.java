package com.lhp.nicole.blog.vo.params;

import lombok.Data;

@Data
public class LoginParams {

    private String username;
    private String password;

    public LoginParams(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
