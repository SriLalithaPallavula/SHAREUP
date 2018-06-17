package com.niit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableWebMvc  //<mvc:annotation-driven> tag in dispatcher-servlet.xml
@ComponentScan(basePackages="com.niit")
//similar to dispatcher-servlet.xml
public class WebAppConfig extends WebMvcConfigurerAdapter{
public WebAppConfig(){
	System.out.println("WebAppConfig class is instantiated");
}
}
