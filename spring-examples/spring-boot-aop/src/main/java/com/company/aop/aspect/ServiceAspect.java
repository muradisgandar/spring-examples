package com.company.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.company.aop.service.MessageService.sendMessage(..))")
    public void beforeSendMessageMethod(JoinPoint joinPoint){
        System.out.println("Parameter is catched before execution of sendMessage: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.company.aop.service.*.*(..))")
    public void afterSendMessageMethod(JoinPoint joinPoint){
        System.out.println("Parameter is catched after execution of sendMessage: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
