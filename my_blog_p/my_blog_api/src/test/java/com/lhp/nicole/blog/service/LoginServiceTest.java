package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.service.impl.LoginServiceImpl;
import com.lhp.nicole.blog.vo.ErrorCode;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.LoginParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
class LoginServiceTest {
    @Autowired
    LoginService loginService;
    @Test
    void testLogin_BlankUsername_ReturnFailure() {
        String username = "";
        String password = "123";
        LoginParams loginParams = new LoginParams(username,password);
        Assertions.assertEquals(1001, loginService.login(loginParams).getCode());
    }

    @Test
    void testLogin_BlankPassword_ReturnFailure() {
        String username = "admin";
        String password = "";
        LoginParams loginParams = new LoginParams(username,password);
        Assertions.assertEquals(1001, loginService.login(loginParams).getCode());
    }

    @Test
    void checkToken() {
    }

    @Test
    void logout() {
    }

    @Test
    void register() {
    }
}