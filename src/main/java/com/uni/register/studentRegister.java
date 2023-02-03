package com.uni.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.uni.register")
public class studentRegister {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "register");
        SpringApplication.run(studentRegister.class, args);
    }

}
