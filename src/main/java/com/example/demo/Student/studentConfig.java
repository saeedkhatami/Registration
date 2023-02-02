package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner cmdrun(
            studentRepository repository) {
        return args -> {
            student james = new student(
                    "james",
                    "james.portin@gmail.com",
                    LocalDate.of(2005, 11, 3)
            );
            repository.saveAll(List.of(james));
        };
    }
}
