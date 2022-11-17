package com.lhp.nicole.blog.handler;

import com.lhp.nicole.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//对加了@Controller注解的方法进行拦截处理 AOP的实现
@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody //return json data
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.failure(-999, "system exception");
    }
}
