package pl.java.scalatech;

import java.math.BigDecimal;

import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Product;
import pl.java.scalatech.domain.Role;
import pl.java.scalatech.repository.ProductRepository;
import pl.java.scalatech.repository.RoleRepository;

@SpringBootApplication
@Slf4j
public class BootCamp {

    @Bean
    CommandLineRunner initProduct(ProductRepository productRepository) {
        return (evt) -> Lists.newArrayList(Product.builder().availability(true).name("hammer").price(BigDecimal.TEN).build(),
                Product.builder().availability(false).name("spoon").price(BigDecimal.valueOf(34, 2)).build(),
                Product.builder().availability(false).name("gun").price(BigDecimal.valueOf(123)).build(),
                Product.builder().availability(true).name("fork").price(BigDecimal.valueOf(23)).build(),
                Product.builder().availability(true).name("car").price(BigDecimal.valueOf(12345)).build()).forEach(a -> {
                    Product loaded = productRepository.save(a);
                    log.info("{}", loaded);
                });
    }

    @Bean
    CommandLineRunner initRole(RoleRepository roleRepository) {
        return (evt) -> Lists.newArrayList(Role.builder().role("USER").build(), Role.builder().role("ADMIN").build(), Role.builder().role("BUSINESS").build()

        ).forEach(a -> {
            Role loaded = roleRepository.save(a);
            log.info("{}", loaded);
        });
    }
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        registration.addInitParameter("webAllowOthers", "true");
        return registration;
    }
    public static void main(String[] args) {
        SpringApplication.run(BootCamp.class, args);
    }
}
