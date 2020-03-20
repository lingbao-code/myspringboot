package com.xzj.springmvc.controller;

import com.xzj.springmvc.Bean.Staff;
import com.xzj.springmvc.Services.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staff_temp")
public class StaffController2 {
    @Autowired
    IStaffService staffService;

    @GetMapping("/get_staff_id")
    public String getStaffById(@RequestParam("staff_id") int staffId){
        System.out.println("调用staffController2控制器");
        Staff staff =staffService.getStaffById(staffId);
        return "";
    }
    @GetMapping("/update_staff")
    public String updateStaff(@Validated Staff staff){
        System.out.println("调用staffController2控制器,更新staff");
        staffService.updateStaff(staff);
        return "";
    }
}
