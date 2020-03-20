package com.xzj;

import com.xzj.bean.Address;
import com.xzj.bean.Customer;
import com.xzj.bean.Film;
import com.xzj.bean.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SakilaConfig.class,
        FilmConfig.class,
        StoreConfig.class,
        DataSourceConfig.class})
@PropertySource(value = "classpath:my.properties")
public class AppTest
{
    @Autowired
    private Customer customer;

    @Autowired
    @Qualifier("film1")
    private Film film1;

    @Autowired
    @Qualifier("film2")
    private Film film2;

    @Test
    public void testCustomer() {

        System.out.println(customer);
        System.out.println(customer.getStore());
    }

    @Test
    public void test2() {
        System.out.println(customer.getAddress().getPhone());
    }

    @Test
    public void testFilm(){
        System.out.println(film1.getLanguage());
        System.out.println(film2.getLanguage());
        System.out.println(film1.getLanguage() == film2.getLanguage());
    }

    @Test
    public void StaffTest(){
        System.out.println(staff);
    }

    @Test
    public void testDataSource(){
        System.out.println(dataSource);
    }
    @Autowired(required = false)
    private Staff staff;


    @Autowired
    private DataSource dataSource;
}
