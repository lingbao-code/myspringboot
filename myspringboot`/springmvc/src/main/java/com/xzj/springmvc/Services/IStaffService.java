package com.xzj.springmvc.Services;

import com.xzj.springmvc.Bean.Staff;

public interface IStaffService {
    public Staff getStaffById(Integer id);
    public void updateStaff(Staff staff);
}
