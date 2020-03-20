package com.xzj;

import com.xzj.bean.Staff;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SakilaConfig.class)
public class StoreConfig {
    @Bean
    @Conditional(StoreExistsCondition.class)
    public Staff staffBean(){
        return new Staff();
    }
}
