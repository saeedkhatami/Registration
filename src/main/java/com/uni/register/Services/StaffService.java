package com.uni.register.Services;

import com.uni.register.Models.Staff;
import com.uni.register.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    public List<Staff> getStaff() {

        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long staffId) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalStateException(
                        "Staff with id" + staffId + " does not exist"
                ));

        return Optional.ofNullable(staff);
    }

    public void addNewStaff(Staff staff) {
        Optional<Staff> stdByEmail = staffRepository.findByEmail(staff.getEmail());
        if (stdByEmail.isPresent()) {
            throw new IllegalStateException("this email is registered");
        }
        staffRepository.save(staff);
    }

    public void deleteStaff(Long staffId) {
        boolean exist = staffRepository.existsById(staffId);
        if (!exist) {
            throw new IllegalStateException("Staff with " + staffId + " does not exist");
        }
        staffRepository.deleteById(staffId);
    }

    @Transactional
    public void updateStaff(Long staffId, Staff UPstaff) {
        Staff REstaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalStateException(
                        "Staff with id " + staffId + " does not exist"));

        if (UPstaff.getFirstName() != null &&
                UPstaff.getFirstName().length() > 0 &&
                !Objects.equals(REstaff.getFirstName(), UPstaff.getFirstName())) {

            REstaff.setFirstName(UPstaff.getFirstName());
        }
        if (UPstaff.getLastName() != null &&
                UPstaff.getLastName().length() > 0 &&
                !Objects.equals(REstaff.getLastName(), UPstaff.getLastName())) {

            REstaff.setLastName(UPstaff.getLastName());
        }
        if (UPstaff.getEmail() != null &&
                UPstaff.getEmail().length() > 0 &&
                !Objects.equals(REstaff.getEmail(), UPstaff.getEmail())) {

            Optional<Staff> studentEmailChange = staffRepository.findByEmail(UPstaff.getEmail());

            if (studentEmailChange.isPresent()) {
                throw new IllegalStateException("This email is registered");
            }
            REstaff.setEmail(UPstaff.getEmail());
        }

        if (UPstaff.getPhoneNumber() != null &&
                UPstaff.getPhoneNumber() > 0 &&
                !Objects.equals(REstaff.getPhoneNumber(), UPstaff.getPhoneNumber())) {
            Optional<Staff> studentPhoneNumberChange = staffRepository.findByPhoneNumber(UPstaff.getPhoneNumber());
            if (studentPhoneNumberChange.isPresent()) {
                throw new IllegalStateException("This Phone number is registered");
            }
            REstaff.setPhoneNumber(UPstaff.getPhoneNumber());
        }
        if (UPstaff.getAddress() != null &&
                UPstaff.getAddress().length() > 0 &&
                !Objects.equals(REstaff.getAddress(), UPstaff.getAddress())) {

            REstaff.setAddress(UPstaff.getAddress());
        }
        if (UPstaff.getDob() != null &&
                !Objects.equals(REstaff.getDob(), UPstaff.getDob())) {

            REstaff.setDob(UPstaff.getDob());
        }
    }
}
