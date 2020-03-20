package com.xzj;


import com.xzj.bean.Customer;
import com.xzj.bean.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.xzj.bean")

public class CoustomerConfig {

    @Bean
    public Customer createCustomer(Payment payment){
        Customer customer = new Customer();
        customer.setPayment(payment);
        return customer;
    }
}
