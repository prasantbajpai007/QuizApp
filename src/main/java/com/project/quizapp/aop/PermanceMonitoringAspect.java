package com.project.quizapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class PermanceMonitoringAspect {
    private  static final Logger LOGGER= LoggerFactory.getLogger(PermanceMonitoringAspect.class);

    @Around("execution(* com.project.quizapp.service.QuestionService.*(..))")
    public  Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start =System.currentTimeMillis();

       Object obj = jp.proceed();

        long end =System.currentTimeMillis();

        LOGGER.info("Time taken : "+(end - start));

        return obj;
    }
}
