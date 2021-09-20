package com.cursoee.vuelos.lanzador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableJpaRepositories(basePackages = "com.cursoee.vuelos.dao")
@EntityScan(basePackages = "com.cursoee.vuelos.model")
@SpringBootApplication(scanBasePackages = {"com.cursoee.vuelos.controller",
										   "com.cursoee.vuelos.service",
										   "com.cursoee.vuelos.lanzador"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//filtro caracteres especiales en spring boot
//	      CharacterEncodingFilter filter = new CharacterEncodingFilter();
//	      filter.setEncoding("UTF-8");
//	      filter.setForceEncoding(true);
//	      FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//	      registrationBean.setFilter(filter);
//	      registrationBean.addUrlPatterns("/*");

	}

}
