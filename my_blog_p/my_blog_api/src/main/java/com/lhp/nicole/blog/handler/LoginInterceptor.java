package com.lhp.nicole.blog.handler;

import com.alibaba.fastjson.JSON;
import com.lhp.nicole.blog.dao.pojo.User;
import com.lhp.nicole.blog.service.LoginService;
import com.lhp.nicole.blog.vo.ErrorCode;
import com.lhp.nicole.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
@Component
@Slf4j  //打印日志
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在调用controller(Handler)方法之前，进行执行，判断登录状态

        // 1. 需要判断 请求的接口路径 是否为HandlerMethod
        // handler有可能是RequestResourceHandler springboot程序访问静态资源，默认去classPath下的static目录查询
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=================request start=================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}",token);
        log.info("=================request end=================");

        // 2. 判断token是否为空，如果为空需要登录
        if(StringUtils.isBlank(token)){
            Result result = Result.failure(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        // 3. 如果token不为空，则登录验证 checkToken
        User user = loginService.checkToken(token);
        if(user == null){
            Result result = Result.failure(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        // 4. 如果认证成功，则通过
        return true;
    }
}
