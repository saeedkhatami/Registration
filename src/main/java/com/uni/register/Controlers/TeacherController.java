package com.uni.register.Controlers;

import com.uni.register.Models.Teacher;
import com.uni.register.Repositories.TeacherRepository;
import com.uni.register.Services.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Teacher controller")
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService,
                             TeacherRepository teacherRepository) {
        this.teacherService = teacherService;
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
