package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.codegym.controller.BookController.do*(..))")
    public void allChangeBookStatus() {
    }

    @Before("allChangeBookStatus()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + " Time: " + LocalDate.now());
    }

    @AfterReturning("allChangeBookStatus()")
    public void afterReturningAllMethod(JoinPoint joinPoint) {
        System.err.println("method " + joinPoint.getSignature().getName() + " đã làm thay đổi trạng thái sách vào " + LocalDate.now());
    }

}
