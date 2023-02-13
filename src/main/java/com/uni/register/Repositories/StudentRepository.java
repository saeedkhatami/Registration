package com.uni.register.Repositories;

import com.uni.register.Models.Student;
import com.uni.register.Repositories.CustomRepository.CustomStudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CustomStudentRepository {
    Student findFirstByOrderByAgeAsc();

    Student findTopByOrderByAgeAsc();

    List<Student> findByOrderByAgeAsc();

    List<Student> findByFirstNameIgnoreCase(String firstName);

    List<Student> findByLastNameOrderByAgeAsc(String lastName);

    List<Student> findByLastName(String lastName, Sort sort);

    @Query("SELECT s FROM Student s WHERE s.id = ?1")
    Optional<Student> findById(Long id);

    @Query("SELECT s from Student s where s.phoneNumber = ?1")
    Optional<Student> findByPhoneNumber(Long phoneNumber);

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findByEmail(String email);


}
