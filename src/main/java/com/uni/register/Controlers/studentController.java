package com.uni.register.Controlers;


import com.uni.register.Models.student;
import com.uni.register.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class studentController {
    private final studentService stdsrv;

    @Autowired
    public studentController(studentService stdsrv) {
        this.stdsrv = stdsrv;
    }

    @GetMapping
    public List<student> getStudent() {
        return stdsrv.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody student student) {
        stdsrv.addNewStudent(student);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(
            @PathVariable("studentID") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        stdsrv.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        stdsrv.deleteStudent(studentId);

    }


}
