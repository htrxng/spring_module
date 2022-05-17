package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.codegym.controller.BookController.do*(..))")
    public void allChangeBookStatus() {
    }

    @AfterReturning("allChangeBookStatus()")
    public void afterReturningAllMethod(JoinPoint joinPoint) {
        System.err.println("method " + joinPoint.getSignature().getName() + " đã làm thay đổi trạng thái sách vào " + LocalDate.now());
    }


}
