package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.vo.ArticleVo;

public interface UserService {

//    ArticleVo findUserVoById(Long id);

    User findUserById(Long id); //查找作者

    User findUser(String username, String password);
}
