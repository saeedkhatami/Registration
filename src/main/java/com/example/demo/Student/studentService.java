package com.example.demo.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {
    private final studentRepository stdrepo;

    @Autowired
    public studentService(studentRepository stdrepo) {
        this.stdrepo = stdrepo;
    }

    public List<student> getStudent() {

        return stdrepo.findAll();
    }

    public void addNewStudent(student student){
        Optional<student> stdByEmail = stdrepo.findByEmail(student.getEmail());
        if (stdByEmail.isPresent()){
            throw new IllegalStateException("this email is registered");
        }
        stdrepo.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exist = stdrepo.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("student with " + studentId + " does not exist");
        }
        stdrepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
    student student = stdrepo.findById(studentId)
            .orElseThrow(() -> new IllegalStateException(
                    "student with id " + studentId + " does not exist"));
    if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)){
        student.setName(name);
        }
    if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)){
        Optional<student> stdEmailChange = stdrepo.findByEmail(email);
        if (stdEmailChange.isPresent()){
        throw new IllegalStateException("this email is registered");
        }
            student.setEmail(email);
    }
    }
}
