package pl.java.scalatech.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class ServiceLoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerBean() {

    }
    
    
    @Before("controllerBean()")
    public void beforeWithin(JoinPoint joinPoint){
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++ {}",joinPoint.getSignature().getName());
        
        
    }
}