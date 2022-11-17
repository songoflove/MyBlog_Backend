package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.LoginParams;

public interface LoginService {
    /*
     * login function
     * @params loginParam
     * @return
     */
    Result login(LoginParams loginParams);

    User checkToken(String token);

    Result logout(String token);

}
