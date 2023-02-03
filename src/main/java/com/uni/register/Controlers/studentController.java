package com.uni.register.Controlers;


import com.uni.register.Models.student;
import com.uni.register.Services.studentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")
public class studentController {
    private final studentService stdsrv;

    @Autowired
    public studentController(studentService stdsrv) {
        this.stdsrv = stdsrv;
    }

    @GetMapping
    @ApiOperation(value="Get all students")
    public List<student> getStudent() {
        return stdsrv.getStudent();
    }


    @GetMapping("{studentID}")
    @ApiOperation(value="Get specific student by id")
    public Optional<student> getStudentByID(
            @PathVariable("studentID") Long studentid) {
        return stdsrv.getstudentbyid(studentid);

    }

    @PostMapping
    @ApiOperation(value="Register new student")
    public void registerNewStudent(@RequestBody student student) {
        stdsrv.addNewStudent(student);
    }

    @PutMapping(path = "{studentID}")
    @ApiOperation(value="Update student properties")
    public void updateStudent(
            @PathVariable("studentID") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        stdsrv.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    @ApiOperation(value="Delete student")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        stdsrv.deleteStudent(studentId);

    }


}
