package ru.gb.homework_10.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        String arguments = Arrays.toString(args);
        System.out.println("Время: " + LocalDateTime.now());
        System.out.println(methodName + ", аргументы: " + arguments);

        return result;
    }

}
