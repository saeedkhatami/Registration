package com.uni.register.Services;

import com.uni.register.Models.Teacher;
import com.uni.register.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public void TeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> getTeacher() {

        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException(
                        "Teacher with id" + teacherId + " does not exist"
                ));

        return Optional.ofNullable(teacher);
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherByEmail = teacherRepository.findByEmail(teacher.getEmail());
        if (teacherByEmail.isPresent()) {
            throw new IllegalStateException("this email is registered");
        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exist = teacherRepository.existsById(teacherId);
        if (!exist) {
            throw new IllegalStateException("Student with " + teacherId + " does not exist");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional
    public void updateTeacher(Long teacherId, Teacher UPteacher) {
        Teacher REteacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException(
                        "Teacher with id " + teacherId + " does not exist"));

        if (UPteacher.getFirstName() != null &&
                UPteacher.getFirstName().length() > 0 &&
                !Objects.equals(REteacher.getFirstName(), UPteacher.getFirstName())) {

            REteacher.setFirstName(UPteacher.getFirstName());
        }
        if (UPteacher.getLastName() != null &&
                UPteacher.getLastName().length() > 0 &&
                !Objects.equals(REteacher.getLastName(), UPteacher.getLastName())) {

            REteacher.setLastName(UPteacher.getLastName());
        }
        if (UPteacher.getEmail() != null &&
                UPteacher.getEmail().length() > 0 &&
                !Objects.equals(REteacher.getEmail(), UPteacher.getEmail())) {

            Optional<Teacher> studentEmailChange = teacherRepository.findByEmail(UPteacher.getEmail());

            if (studentEmailChange.isPresent()) {
                throw new IllegalStateException("This email is registered");
            }
            REteacher.setEmail(UPteacher.getEmail());
        }

        if (UPteacher.getPhoneNumber() != null &&
                UPteacher.getPhoneNumber() > 0 &&
                !Objects.equals(REteacher.getPhoneNumber(), UPteacher.getPhoneNumber())) {
            Optional<Teacher> studentPhoneNumberChange = teacherRepository.findByPhoneNumber(UPteacher.getPhoneNumber());
            if (studentPhoneNumberChange.isPresent()) {
                throw new IllegalStateException("This Phone number is registered");
            }
            REteacher.setPhoneNumber(UPteacher.getPhoneNumber());
        }
        if (UPteacher.getAddress() != null &&
                UPteacher.getAddress().length() > 0 &&
                !Objects.equals(REteacher.getAddress(), UPteacher.getAddress())) {

            REteacher.setAddress(UPteacher.getAddress());
        }
        if (UPteacher.getDob() != null &&
                !Objects.equals(REteacher.getDob(), UPteacher.getDob())) {

            REteacher.setDob(UPteacher.getDob());
        }
        if (UPteacher.getMajor() != null &&
                !Objects.equals(REteacher.getMajor(), UPteacher.getMajor())) {

            REteacher.setMajor(UPteacher.getMajor());
        }
    }
}
