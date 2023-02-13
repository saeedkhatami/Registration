package com.uni.register.Repositories.Implementation;

import com.uni.register.Models.Teacher;
import com.uni.register.Repositories.CustomRepository.CustomTeacherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeacherRepositoryImpl implements CustomTeacherRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> findOrderedByAgeLimitedTo(Integer limit) {
        return entityManager.createQuery("SELECT p FROM Teacher p ORDER BY p.age",
                Teacher.class).setMaxResults(limit).getResultList();
    }
}
