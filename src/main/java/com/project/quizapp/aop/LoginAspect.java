package com.project.quizapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class LoginAspect {

    private  static final Logger LOGGER= LoggerFactory.getLogger(LoginAspect.class);
   //inside execution we need to pass (Return type, fully qualified class,method ,Args)
   @Before("execution(* com.project.quizapp.service.QuestionService.getAllQuestions(..))") // if we want more methods the we can add with "||" symbol
    public void logBeforeMethodCall(JoinPoint jp)
    {
       LOGGER.info("Before Method call"+jp.getSignature().getName());
    }

    @After("execution(* com.project.quizapp.service.QuestionService.*(..))")
    public void logAfterMethodCall(JoinPoint jp)
    {
        LOGGER.info("After Method call"+jp.getSignature().getName());
    }


}
