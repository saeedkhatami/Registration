package com.uni.register.Repositories.CustomRepository;

import com.uni.register.Models.Student;

import java.util.List;

public interface CustomStudentRepository {
    List<Student> findOrderedByAgeLimitedTo(Integer limit);
}
