package com.xzj.springmvc;

import com.xzj.springmvc.Bean.Staff;
import com.xzj.springmvc.controller.StaffController;
import com.xzj.springmvc.dao.StaffDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class SpringmvcApplicationTests {

    @Autowired
    StaffController staffController;
    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
        //System.out.println(staffController.login());
        //模拟http请求
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/staff/login")
                            .accept(MediaType.TEXT_HTML))
                            .andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            System.out.println(response.getStatus());
            System.out.println(response.getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    StaffDAO staffDAO;

    @Test
    public void testStaffDao(){
        Staff staff = staffDAO.getStaffById(1);
        System.out.println(staff);
        System.out.println(staff.getFirstName());
        System.out.println(staff.getLastName());
        System.out.println(staffDAO.getStaffAll().size());
    }
}
