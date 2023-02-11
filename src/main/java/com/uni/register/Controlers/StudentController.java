package com.uni.register.Controlers;

import com.uni.register.Models.Student;
import com.uni.register.Repositories.StudentRepository;
import com.uni.register.Services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api("Student controller")
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
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

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getAllStudentPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {

        try {
            List<Student> content = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<Student> studentPage;
            if (name == null)
                studentPage = studentRepository.findAll(paging);
            else
                studentPage = studentRepository.findByTitleContainingIgnoreCase(name, paging);

            content = studentPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("result", content);
            response.put("currentPage", studentPage.getNumber());
            response.put("totalItems", studentPage.getTotalElements());
            response.put("totalPages", studentPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
