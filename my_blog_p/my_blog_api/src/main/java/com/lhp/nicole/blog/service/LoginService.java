package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.LoginParams;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginService {
    /*
     * Login account
     * @params loginParams
     * @return
     */
    Result login(LoginParams loginParams);

    /*
     * Check token
     * @params token
     * @return
     */
    User checkToken(String token);

    /*
     * Log out account
     * @params token
     * @return
     */
    Result logout(String token);

    /*
     * Register account
     * @params loginParams
     * @return
     */
    Result register(LoginParams loginParams);

}
