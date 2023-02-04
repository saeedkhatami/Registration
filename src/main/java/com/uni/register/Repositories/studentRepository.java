package com.uni.register.Repositories;

import com.uni.register.Models.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    @Query("SELECT s FROM student s WHERE s.id = ?1")
    Optional<student> findById(Long id);

    @Query("SELECT s from student s where s.phoneNumber = ?1")
    Optional<student> findByPhoneNumber(Long phonenumber);

    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<student> findByEmail(String email);
}
