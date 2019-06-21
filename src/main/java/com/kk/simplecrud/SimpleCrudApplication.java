package com.kk.simplecrud;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;

@EnableSwagger2
@SpringBootApplication
public class SimpleCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrudApplication.class, args);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

}
