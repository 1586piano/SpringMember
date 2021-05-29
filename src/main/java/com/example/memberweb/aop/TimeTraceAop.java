package com.example.memberweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    //@Around("execution(* com.example.memberweb..*(..))") //전부 적용
    @Around("execution(* com.example.memberweb.controller.MemberController.create(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        //start method 출력
        System.out.println("START: " + joinPoint.toString());
        try{
            //다음 메서드로 진행
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + ", time : " + timeMs );
        }

    }
}
