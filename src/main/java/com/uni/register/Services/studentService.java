package com.uni.register.Services;


import com.uni.register.Models.student;
import com.uni.register.Repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {
    private final studentRepository studentRepo;

    @Autowired
    public studentService(studentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<student> getStudent() {

        return studentRepo.findAll();
    }

    public Optional<student> getStudentById(Long studentId) {
        student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id" + studentId + " does not exist"
                ));

        return Optional.ofNullable(student);
    }

    public void addNewStudent(student student) {
        Optional<student> stdByEmail = studentRepo.findByEmail(student.getEmail());
        if (stdByEmail.isPresent()) {
            throw new IllegalStateException("this email is registered");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepo.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("Student with " + studentId + " does not exist");
        }
        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, student UPstudent) {
        /*
        *    student
        *       name
        *       email
        *       phone number
        *       address
        *       date of birth
        *       major
        */
        student REstudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist"));

        if (UPstudent.getName() != null &&
                UPstudent.getName().length() > 0 &&
                !Objects.equals(REstudent.getName(), UPstudent.getName())) {

            REstudent.setName(UPstudent.getName());
        }
        if (UPstudent.getEmail() != null &&
                UPstudent.getEmail().length() > 0 &&
                !Objects.equals(REstudent.getEmail(), UPstudent.getEmail())) {

            Optional<student> studentEmailChange = studentRepo.findByEmail(UPstudent.getEmail());

            if (studentEmailChange.isPresent()) {
                throw new IllegalStateException("This email is registered");
            }
            REstudent.setEmail(UPstudent.getEmail());
        }

        if(UPstudent.getPhoneNumber() != null &&
                UPstudent.getPhoneNumber() > 0 &&
                !Objects.equals(REstudent.getPhoneNumber(), UPstudent.getPhoneNumber())){
            Optional<student> studentPhonenumberChange = studentRepo.findByPhoneNumber(UPstudent.getPhoneNumber());
            if(studentPhonenumberChange.isPresent()) {
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
