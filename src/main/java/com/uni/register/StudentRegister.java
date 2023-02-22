package com.uni.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.uni.register")
public class StudentRegister {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "register");
        SpringApplication.run(StudentRegister.class, args);
    }

}
