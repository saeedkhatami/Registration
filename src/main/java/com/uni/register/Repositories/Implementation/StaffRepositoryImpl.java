package com.uni.register.Repositories.Implementation;

import com.uni.register.Models.Staff;
import com.uni.register.Repositories.CustomRepository.CustomStaffRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StaffRepositoryImpl implements CustomStaffRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Staff> findOrderedByAgeLimitedTo(Integer limit) {
        return entityManager.createQuery("SELECT p FROM Staff p ORDER BY p.age",
                Staff.class).setMaxResults(limit).getResultList();
    }
}
