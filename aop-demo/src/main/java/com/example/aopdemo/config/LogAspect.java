package com.example.aopdemo.config;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.example.aopdemo..*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)
    {
        // 接受请求，记录请求内容
        // 获取httpServletRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 记录日志
        logger.info("我在接口返回数据之前执行");
        logger.info("URL : {}", request.getRequestURL().toString());
        logger.info("IP : {}", request.getRemoteAddr());
    }


    @AfterReturning(returning = "res", pointcut = "webLog()")
    public void doAfterReturning(Object res)
    {
        // 处理完请求，返回内容，并记录日志
        logger.info("我在接口返回数据之后执行");
        logger.info("Response:{}", res.toString());

    }
}
