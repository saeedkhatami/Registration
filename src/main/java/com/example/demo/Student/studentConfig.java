package com.example.demo.Student;

import com.example.demo.Student.Models.Majors;
import com.example.demo.Student.Models.student;
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
                    12345678901L,
                    "address",
                    LocalDate.of(2005, 11, 3),
                    Majors.ComputerSciences
            );
            repository.saveAll(List.of(james));
        };
    }
}
