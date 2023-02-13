package com.uni.register.Repositories.Implementation;

import com.uni.register.Models.Student;
import com.uni.register.Repositories.CustomRepository.CustomStudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudentRepositoryImpl implements CustomStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findOrderedByAgeLimitedTo(Integer limit) {
        return entityManager.createQuery("SELECT p FROM Student p ORDER BY p.age",
                Student.class).setMaxResults(limit).getResultList();
    }
}
