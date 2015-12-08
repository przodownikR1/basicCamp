package pl.java.scalatech.aop;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class ServiceLoggingAspect {

    @PostConstruct
    public void init(){
        log.info("###################################################### serviceloggingAspect");
    }
    
   /* @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controllerBean() {    
    }
    
    @Pointcut("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
        log.info("################ Invoked: ");
    }
    
    @Pointcut("execution(* *(..))")
    public void method() {}*/
    
    
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void withinController() {
    }

    @Pointcut("execution(* *(..))")
    public void anyMethod() {
    }

    @AfterReturning("withinController() && anyMethod()")
    public void whenControllerMethodReturns() {
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++ ");
    }
    
    
    @Before("withinController() && anyMethod()")
    public void beforeWithin(JoinPoint joinPoint){
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++ {}",joinPoint.getSignature().getName());
        
        
    }
}