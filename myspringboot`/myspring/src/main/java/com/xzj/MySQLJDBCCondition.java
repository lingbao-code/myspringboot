package com.xzj;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySQLJDBCCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        Resource r = conditionContext.getResourceLoader().getResource("classpath:jdbc-mysql.properties");
        if(!r.exists()){
            return false;
        }
        Environment env = conditionContext.getEnvironment();
        String url = env.getProperty("url");
        if(url!=null&&!"".equals(url)){
            return true;
        }
        return false;
    }
}
