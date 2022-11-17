package com.lhp.nicole.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhp.nicole.blog.dao.mapper.UserMapper;
import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.service.LoginService;
import com.lhp.nicole.blog.service.UserService;
import com.lhp.nicole.blog.vo.ErrorCode;
import com.lhp.nicole.blog.vo.LoginUserVo;
import com.lhp.nicole.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private LoginService loginService;

    @Override
    public User findUserById(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            user = new User();
            user.setUsername("author111");
        }
        return user;
    }

    @Override
    public User findUser(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        queryWrapper.eq(User::getPassword,password);
        queryWrapper.select(User::getUsername,User::getId);
        queryWrapper.last("limit 1");
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        /*
         * 1.token合法性校验
         *    - 是否为空，解析是否成功，redis是否存在
         * 2.如果校验失败，返回错误
         * 3.如果成功，返回对应结果
         */

        User user = loginService.checkToken(token);
        if(user == null) {
            Result.failure(ErrorCode.TOKEN_INVALID.getCode(), ErrorCode.TOKEN_INVALID.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setId(user.getId());
        loginUserVo.setUsername(user.getUsername());
        return Result.success(loginUserVo);
    }
}
