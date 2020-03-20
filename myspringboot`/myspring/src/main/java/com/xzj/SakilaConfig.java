package com.xzj;

import com.xzj.bean.IBean;
import com.xzj.controller.IController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//声明此类为配置类
@ComponentScan(basePackageClasses = {IBean.class, IController.class})//声明组件扫描

public class SakilaConfig {

}
