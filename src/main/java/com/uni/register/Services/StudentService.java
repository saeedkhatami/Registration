package com.uni.register.Services;


import com.uni.register.Models.Student;
import com.uni.register.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id" + studentId + " does not exist"
                ));

        return Optional.ofNullable(student);
    }

    public void addNewStudent(Student student) {
        Optional<Student> stdByEmail = studentRepository.findByEmail(student.getEmail());
        if (stdByEmail.isPresent()) {
            throw new IllegalStateException("this email is registered");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("Student with " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, Student UPstudent) {
        Student REstudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist"));

        if (UPstudent.getFirstName() != null &&
                UPstudent.getFirstName().length() > 0 &&
                !Objects.equals(REstudent.getFirstName(), UPstudent.getFirstName())) {

            REstudent.setFirstName(UPstudent.getFirstName());
        }
        if (UPstudent.getLastName() != null &&
                UPstudent.getLastName().length() > 0 &&
                !Objects.equals(REstudent.getLastName(), UPstudent.getLastName())) {

            REstudent.setLastName(UPstudent.getLastName());
        }
        if (UPstudent.getEmail() != null &&
                UPstudent.getEmail().length() > 0 &&
                !Objects.equals(REstudent.getEmail(), UPstudent.getEmail())) {

            Optional<Student> studentEmailChange = studentRepository.findByEmail(UPstudent.getEmail());

            if (studentEmailChange.isPresent()) {
                throw new IllegalStateException("This email is registered");
            }
            REstudent.setEmail(UPstudent.getEmail());
        }

        if (UPstudent.getPhoneNumber() != null &&
                UPstudent.getPhoneNumber() > 0 &&
                !Objects.equals(REstudent.getPhoneNumber(), UPstudent.getPhoneNumber())) {
            Optional<Student> studentPhoneNumberChange = studentRepository.findByPhoneNumber(UPstudent.getPhoneNumber());
            if (studentPhoneNumberChange.isPresent()) {
                throw new IllegalStateException("This Phone number is registered");
            }
            REstudent.setPhoneNumber(UPstudent.getPhoneNumber());
        }
        if (UPstudent.getAddress() != null &&
                UPstudent.getAddress().length() > 0 &&
                !Objects.equals(REstudent.getAddress(), UPstudent.getAddress())) {

            REstudent.setAddress(UPstudent.getAddress());
        }
        if (UPstudent.getDob() != null &&
                !Objects.equals(REstudent.getDob(), UPstudent.getDob())) {

            REstudent.setDob(UPstudent.getDob());
        }
        if (UPstudent.getMajor() != null &&
                !Objects.equals(REstudent.getMajor(), UPstudent.getMajor())) {

            REstudent.setMajor(UPstudent.getMajor());
        }
    }
}
