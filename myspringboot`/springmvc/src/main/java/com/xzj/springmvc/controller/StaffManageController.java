package com.xzj.springmvc.controller;


import com.xzj.springmvc.Bean.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/staffmgr")
@Validated
public class StaffManageController {
    @CrossOrigin(origins = {"*"})
    @PostMapping("/add")
    @ResponseBody
    public String addStaff(@Validated Staff staff, BindingResult result) {
        String message = null;
        if (result.hasErrors()) {
            List<ObjectError> listErrors = result.getAllErrors();
            for (ObjectError err :
                    listErrors) {
                FieldError error = (FieldError) err;
                System.out.println(err.getObjectName() + "," + error.getField() + ":" + error.getDefaultMessage());
                message += error.getDefaultMessage()+"</br>";
            }
        }
        return message;
    }
}
