package com.zh.publiccode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.zh.publiccode.dao")
@EnableSwagger2
public class PublicCodeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PublicCodeApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 设置启动类,返回spring应用构建对象
        return builder.sources(PublicCodeApplication.class);
    }

}
