package cn.itcast.springboot.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = "cn.itcast.springboot.java.config") //配置扫描包
@PropertySource(value= {"classpath:db.properties"}, ignoreResourceNotFound = true)
public class SpringConfig {
	
//	@Value("${jdbc.url}")
//	private String jdbcUrl;
    
    @Bean // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>
    public UserDao getUserDAO(){
        return new UserDao(); // 直接new对象做演示
    }
}

