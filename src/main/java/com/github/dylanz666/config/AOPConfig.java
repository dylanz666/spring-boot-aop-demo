package com.github.dylanz666.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author : dylanz
 * @since : 10/22/2020
 */
@Configuration
@Aspect
public class AOPConfig {
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAop(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        System.out.println("client ip: " + request.getRemoteAddr());

        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("args: " + Arrays.asList(args));

        Object object = proceedingJoinPoint.proceed();
        System.out.println("return: " + object);

        return object;
    }
}
