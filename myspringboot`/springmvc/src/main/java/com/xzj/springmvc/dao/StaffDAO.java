package com.xzj.springmvc.dao;

import com.xzj.springmvc.Bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Staff getStaffById(int id){
        //RowMapper接口映射到java对象

        //int n = this.jdbcTemplate.queryForObject("select count(*) from staff ", Integer.class);
        //System.out.println(n);

        Staff staff = this.jdbcTemplate.queryForObject("SELECT * from staff where staff_id="+id,
                new BeanPropertyRowMapper<Staff>(Staff.class));
        return staff;
    }
    public List<Staff> getStaffAll(){
        //RowMapper接口映射到java对象

        //int n = this.jdbcTemplate.queryForObject("select count(*) from staff ", Integer.class);
        //System.out.println(n);

        /*Staff staff = this.jdbcTemplate.queryForObject("SELECT * from staff where staff_id="+id,
                new BeanPropertyRowMapper<Staff>(Staff.class));
        return staff;*/

        return  this.jdbcTemplate.query("select * from staff",
                new BeanPropertyRowMapper<>(Staff.class));
    }
    public int insertStaff(Staff staff){
        return this.jdbcTemplate.update("insert into staff(staff_id,first_name,last_name,address_id,store_id,username)values(?,?,?,?,?,?)",
                new Object[]{staff.getStaffId(),staff.getFirstName(),staff.getLastName(),
                        staff.getAddr().getAddressId(),staff.getStore().getStoreId(),staff.getUsername()});
    }
}
