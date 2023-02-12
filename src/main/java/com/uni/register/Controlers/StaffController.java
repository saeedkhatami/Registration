package com.uni.register.Controlers;

import com.uni.register.Models.Staff;
import com.uni.register.Repositories.StaffRepository;
import com.uni.register.Services.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Staff controller")
@RequestMapping(path = "/api/v1/staff")
public class StaffController {
    private final StaffService staffService;
    private final StaffRepository staffRepository;

    @Autowired
    public StaffController(StaffService staffService,
                           StaffRepository staffRepository) {
        this.staffService = staffService;
        this.staffRepository = staffRepository;
    }

    @GetMapping
    @ApiOperation(value = "Get all staffs")
    public List<Staff> getStaff() {
        return staffService.getStaff();
    }


    @GetMapping("{staffId}")
    @ApiOperation(value = "Get specific staff by id")
    public Optional<Staff> getTeacherById(
            @PathVariable("staffId") Long staffId) {
        return staffService.getStaffById(staffId);
    }

    @PostMapping
    @ApiOperation(value = "Register new staff")
    public void registerNewTeacher(@RequestBody Staff staff) {
        staffService.addNewStaff(staff);
    }

    @PutMapping(path = "{staffId}")
    @ApiOperation(value = "Update staff properties")
    public void updateTeacher(
            @RequestBody Staff staff,
            @PathVariable("staffId") Long staffId) {
        staffService.updateStaff(staffId, staff);
    }

    @DeleteMapping(path = "{staffId}")
    @ApiOperation(value = "Delete staff")
    public void deleteTeacher(@PathVariable("staffId") Long staffId) {
        staffService.deleteStaff(staffId);
    }
}
