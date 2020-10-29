package com.jinqian;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@Slf4j
@MapperScan({"com.jinqian.cloundprint.*","com.jinqian.pay.*"})
public class CloundprintApplication {

    public static void main(String[] args) {

        log.info("开始加载.................");
        SpringApplication.run(CloundprintApplication.class, args);
        log.info("加载完成.................");
    }

}
