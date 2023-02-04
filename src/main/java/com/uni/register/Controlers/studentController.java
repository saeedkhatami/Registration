package com.uni.register.Controlers;

import com.uni.register.Models.student;
import com.uni.register.Services.studentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")
public class studentController {
    private final studentService studentService;

    @Autowired
    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ApiOperation(value="Get all students")
    public List<student> getStudent() {
        return studentService.getStudent();
    }


    @GetMapping("{studentID}")
    @ApiOperation(value="Get specific student by id")
    public Optional<student> getStudentByID(
            @PathVariable("studentID") Long studentid) {
        return studentService.getStudentById(studentid);
    }

    @PostMapping
    @ApiOperation(value="Register new student")
    public void registerNewStudent(@RequestBody student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentID}")
    @ApiOperation(value="Update student properties")
    public void updateStudent(
            @RequestBody student student,
            @PathVariable("studentID") Long studentId) {
        studentService.updateStudent(studentId, student);
    }

    @DeleteMapping(path = "{studentId}")
    @ApiOperation(value="Delete student")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);

    }
}
