package com.xzj.springmvc.controller;


import com.xzj.springmvc.Bean.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/login")
    public @ResponseBody String login(){
        System.out.println("登录");
        //return "home";
        // 视图的名称为home，根据配置会找到对应的/myspringboot/home.html没有加@ResponseBody时
        return "hello spring boot";
    }

    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String reqStaff(){

        return "";
    }

    /*@RequestMapping(path = "/get/{all}/{staff_id}.action",method = RequestMethod.GET)
    public String getStaff(@PathVariable("staff_id")int staffId,@PathVariable("all")String p ){
        System.out.println("获取职员"+staffId);
        System.out.println("参数p"+p);
        return "";
    }*/
    @RequestMapping(path = "/get/{all}/*.action",method = RequestMethod.GET)
    public String getStaffById(@PathVariable("all")String p ){
        //System.out.println("获取职员"+staffId);
        System.out.println("参数p"+p);
        return "";
    }


    @GetMapping(value = "/get_all_staff", produces = "application/json")
    public @ResponseBody List<Staff> getStaffAll(){
        List<Staff> list = new ArrayList<>();
        list.add(new Staff(1,"a","b"));
        list.add(new Staff(2,"c","d"));
        list.add(new Staff(3,"e","f"));
        list.add(new Staff(4,"g","h"));
        return list;
    }

    @GetMapping(value = "/update_staff",params = "action=update")
    public String updateStafff(){
        System.out.println("更新staff操作");
        return "ok";
    }

    @GetMapping(value = "/save_staff")
    public @ResponseBody String saveStaff(Staff staff,String lastName){
        System.out.println(staff.getStaffId());
        System.out.println(staff.getFirstName());
        System.out.println(staff.getLastName());
        System.out.println(lastName);
        return "ok";
    }


    @GetMapping(value = "/save_staff_2")
    public @ResponseBody String saveStaff(@RequestParam("id") int staffId,String lastName,String firstName){
        System.out.println(lastName);
        System.out.println(staffId);
        return "ok";
    }

    @PostMapping(value = "/save_staff_3")
    public @ResponseBody String saveStaff3(Staff staff){
        System.out.println(staff.getStaffId());
        System.out.println(staff.getFirstName());
        return "ok";
    }

    //@CrossOrigin(origins = {"https://127.0.0.1:5500"})
    @RequestMapping(value = "/query_staff",method = RequestMethod.GET)
    public @ResponseBody Object getStaffDate( ){
        System.out.println("XXXXXXXXXXXXXXXXXXX");
        List<Staff> list1 = new ArrayList<>();
        list1.add(new Staff(11,"a1","b1"));
        list1.add(new Staff(22,"c1","e1"));
        list1.add(new Staff(33,"f1","g1"));
        return list1;
    }
}
