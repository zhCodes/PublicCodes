package com.zh.publiccode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.zh.publiccode.dao")
@EnableSwagger2
public class PublicCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicCodeApplication.class, args);
    }

}
