package com.example.roombooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.roombooking.config.JwtFilter;


@SuppressWarnings({ "rawtypes", "unchecked" })
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RoomBookingSystemApplication {

	
	
//	@Bean
//	public FilterRegistrationBean jwtFilter()
//	{
//		final FilterRegistrationBean registrationBean=new FilterRegistrationBean();
//			registrationBean.setFilter(new JwtFilter());
//		    registrationBean.addUrlPatterns("/api/*");
//			return registrationBean;
//	
//	}
	public static void main(String[] args) 
	{
		SpringApplication.run(RoomBookingSystemApplication.class, args);
		System.out.println("Online Room Booking System Project is running !!!");
	}

	

}
