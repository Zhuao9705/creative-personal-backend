package com.zhuao.backend.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhuao.backend")
public class ZhuaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhuaoApplication.class, args);
    }

}
