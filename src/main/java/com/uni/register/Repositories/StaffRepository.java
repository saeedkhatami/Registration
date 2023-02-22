package com.uni.register.Repositories;

import com.uni.register.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("SELECT s FROM Staff s WHERE s.id = ?1")
    Optional<Staff> findById(Long id);

    @Query("SELECT s from Staff s where s.phoneNumber = ?1")
    Optional<Staff> findByPhoneNumber(Long phoneNumber);

    @Query("SELECT s FROM Staff s WHERE s.email = ?1")
    Optional<Staff> findByEmail(String email);
}
