package com.uni.register.Controlers;

import com.uni.register.Models.Student;
import com.uni.register.Repositories.StudentRepository;
import com.uni.register.Services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Student controller")
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @GetMapping
    @ApiOperation(value = "Get all students")
    public List<Student> getStudent() {
        return studentService.getStudent();
    }


    @GetMapping("{studentID}")
    @ApiOperation(value = "Get specific student by id")
    public Optional<Student> getStudentByID(
            @PathVariable("studentID") Long studentid) {
        return studentService.getStudentById(studentid);
    }

    @PostMapping
    @ApiOperation(value = "Register new student")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentID}")
    @ApiOperation(value = "Update student properties")
    public void updateStudent(
            @RequestBody Student student,
            @PathVariable("studentID") Long studentId) {
        studentService.updateStudent(studentId, student);
    }

    @DeleteMapping(path = "{studentId}")
    @ApiOperation(value = "Delete student")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);

    }
}
