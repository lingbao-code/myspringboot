package com.xzj.springmvc.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class UserController {

    @RequestMapping("/login")
    public String login(@RequestParam("phone") String phoneNum, HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getClass());
        System.out.println(session.getId());
        session.setAttribute("USER_INF", phoneNum);
        //跳转 return "index";
        return "redirect: ../index.html";//转发
    }
}
