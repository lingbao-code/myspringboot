package com.xzj;

import com.xzj.bean.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Customer customer1 = ctx.getBean(Customer.class);
        Customer customer2 = ctx.getBean(Customer.class);

        System.out.println(customer1 == customer2);
    }
}
