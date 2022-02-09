package com.fastcampus.practice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.fastcampus.practice.controller..*)")
    public void onRequest() {
    }

    @Around("onRequest()")
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            final long end = System.currentTimeMillis();
            log.info("target: {}", joinPoint.getSignature());
            log.warn("걸린시간: {}ms", end - start);
        }
    }
}
