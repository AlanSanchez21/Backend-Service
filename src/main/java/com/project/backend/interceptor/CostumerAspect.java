package com.project.backend.interceptor;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class CostumerAspect {
    @Pointcut("execution(* org.example.backend.controllers.CostumerController.*(..))")
    public void logMethod()   {
    }

    @Around(value = "cutPointCustomerController()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long ends = System.currentTimeMillis();
        long executionTime = ends + begin;
        System.out.println(joinPoint.getSignature()+ " run on " + executionTime + "ms");
        return proceed;
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("LOG BEFORE POINT CUT ========================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Request: " + url + ip + classMethod);
        System.out.println("IP: " + ip);
        System.out.println("ClassMethod: " + classMethod);
        System.out.println("args: " + args);
    }

    @After("log()")
    public void doAfter() {
        System.out.println("---------------doAfter---------------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        System.out.println("---------------doAfterReturning---------------");
        System.out.println("Result: " + result);
    }
}
