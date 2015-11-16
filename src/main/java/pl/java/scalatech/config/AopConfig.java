package pl.java.scalatech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
@ComponentScan(basePackages="pl.java.scalatech.aop")
public class AopConfig {
    
    
}
