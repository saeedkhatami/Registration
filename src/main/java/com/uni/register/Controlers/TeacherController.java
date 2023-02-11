package com.uni.register.Controlers;

import com.uni.register.Models.Student;
import com.uni.register.Models.Teacher;
import com.uni.register.Repositories.StudentRepository;
import com.uni.register.Repositories.TeacherRepository;
import com.uni.register.Services.TeacherService;
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
@Api("Teacher controller")
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherService teacherService,
                             TeacherRepository teacherRepository) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    @ApiOperation(value = "Get all teachers")
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }


    @GetMapping("{teacherID}")
    @ApiOperation(value = "Get specific teacher by id")
    public Optional<Teacher> getTeacherById(
            @PathVariable("teacherID") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getAllTeachersPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {

        try {
            List<Teacher> content = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<Teacher> teacherPage;
            if (name == null)
                teacherPage = teacherRepository.findAll(paging);
            else
                teacherPage = teacherRepository.findByTitleContainingIgnoreCase(name, paging);

            content = teacherPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("result", content);
            response.put("currentPage", teacherPage.getNumber());
            response.put("totalItems", teacherPage.getTotalElements());
            response.put("totalPages", teacherPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    @ApiOperation(value = "Register new Teacher")
    public void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "{teacherId}")
    @ApiOperation(value = "Update teacher properties")
    public void updateTeacher(
            @RequestBody Teacher teacher,
            @PathVariable("teacherId") Long teacherId) {
        teacherService.updateTeacher(teacherId, teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    @ApiOperation(value = "Delete teacher")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);

    }
}
