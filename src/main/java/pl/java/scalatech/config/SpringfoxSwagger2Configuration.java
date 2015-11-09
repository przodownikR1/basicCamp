package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
class SpringfoxSwagger2Configuration {

}