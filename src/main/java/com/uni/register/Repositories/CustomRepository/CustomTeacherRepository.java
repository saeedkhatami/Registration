package com.uni.register.Repositories.CustomRepository;

import com.uni.register.Models.Teacher;

import java.util.List;


public interface CustomTeacherRepository {
    List<Teacher> findOrderedByAgeLimitedTo(Integer limit);
}
