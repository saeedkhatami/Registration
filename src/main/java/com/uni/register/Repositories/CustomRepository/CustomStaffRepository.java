package com.uni.register.Repositories.CustomRepository;

import com.uni.register.Models.Staff;

import java.util.List;

public interface CustomStaffRepository {
    List<Staff> findOrderedByAgeLimitedTo(Integer limit);
}
