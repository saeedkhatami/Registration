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
            student saeed = new student(
                    "james",
                    "james.portin@gmail.com",
                    LocalDate.of(2005, 11, 3)
                    );
            student pooya = new student(
                    "charlie",
                    "chambooo@yahoo.com",
                    LocalDate.of(2004, 1, 9)
                    );
            repository.saveAll(List.of(saeed, pooya));
        };
    }
}
