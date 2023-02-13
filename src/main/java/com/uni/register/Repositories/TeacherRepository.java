package com.uni.register.Repositories;

import com.uni.register.Models.Teacher;
import com.uni.register.Repositories.CustomRepository.CustomTeacherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, CustomTeacherRepository {
    Teacher findFirstByOrderByAgeAsc();

    Teacher findTopByOrderByAgeAsc();

    List<Teacher> findByOrderByAgeAsc();

    List<Teacher> findByFirstNameIgnoreCase(String firstName);

    List<Teacher> findByLastNameOrderByAgeAsc(String lastName);

    List<Teacher> findByLastName(String lastName, Sort sort);

    @Query("SELECT s FROM Teacher s WHERE s.id = ?1")
    Optional<Teacher> findById(Long id);

    @Query("SELECT s from Teacher s where s.phoneNumber = ?1")
    Optional<Teacher> findByPhoneNumber(Long phoneNumber);

    @Query("SELECT s FROM Teacher s WHERE s.email = ?1")
    Optional<Teacher> findByEmail(String email);


}
