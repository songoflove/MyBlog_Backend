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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;
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

    @Override
    public User checkToken(String token) {
        if(StringUtils.isBlank(token)){  //判断是否为空
            return null;
        }
        Map<String,Object> stringObjectMap = JWTUtils.checkToken(token);  //JWT校验
        if(stringObjectMap == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);  //redis校验
        if(StringUtils.isBlank(userJson)){
            return null;
        }
        User user = JSON.parseObject(userJson, User.class);
        return user;
    }
//log out
    @Override
    public Result logout(String token) {
        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);
    }
//Register
    @Override
    public Result register(LoginParams loginParams) {

        String username = loginParams.getUsername();
        String password = loginParams.getPassword();
        // 1.判断参数 是否合法
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return Result.failure(ErrorCode.PARAMS_INVALID.getCode(), ErrorCode.PARAMS_INVALID.getMsg());
        }
        // 2.判断账户是否存在，若存在返回“账户已被注册”
        User user = userService.findUserbyUsername(username);
        if(user != null){
            return Result.failure(ErrorCode.ACCOUNT_EXIST.getCode(),ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        // 3.如果账户不存在，则注册用户
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(DigestUtils.md5Hex(password+salt));
        newUser.setCreatedDate(LocalDateTime.now());
        this.userService.save(newUser);
        // 4.生成token
        String token = JWTUtils.createToken(newUser.getId());
        // 5.存入redis,并返回
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(newUser),1, TimeUnit.DAYS);
        return Result.success(token);
         // 6.注：加上事务，一旦中间任何过程出现问题，注册的用户需要回滚 => 在login接口上添加事务的注解
    }
}
