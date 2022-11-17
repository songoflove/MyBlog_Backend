package com.lhp.nicole.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.service.LoginService;
import com.lhp.nicole.blog.service.UserService;
import com.lhp.nicole.blog.utils.JWTUtils;
import com.lhp.nicole.blog.vo.ErrorCode;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.LoginParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final String salt = "lhpblog!@#";  //加密字符串
    @Override
    public Result login(LoginParams loginParams) {
        /*
         * 1.检查参数是否合法
         * 2.根据用户名和密码去user表中查询是否存在
         * 3.如果不存在，登录失败
         * 4.如果存在，使用jwt生成token,返回给前端
         * 5.token放入redis中，redis token:user 信息 设置过期时间
         * （登录认证时，先认证token字符串是否合法，然后去redis认证是否存在）
         */
        String username = loginParams.getUsername();
        String password = loginParams.getPassword();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.failure(ErrorCode.PARAMS_INVALID.getCode(), ErrorCode.PARAMS_INVALID.getMsg());
        }
        password = DigestUtils.md5Hex(password + salt);  //加密
        User user = userService.findUser(username,password);
        if(user == null){
            return Result.failure(ErrorCode.USER_PWD_NOT_EXIST.getCode(), ErrorCode.USER_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(user.getId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(user),1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
