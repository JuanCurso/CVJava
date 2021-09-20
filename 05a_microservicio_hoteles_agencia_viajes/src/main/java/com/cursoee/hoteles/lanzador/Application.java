package com.cursoee.hoteles.lanzador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableJpaRepositories(basePackages = "com.cursoee.hoteles.dao")
@EntityScan(basePackages = "com.cursoee.hoteles.model")
@SpringBootApplication(scanBasePackages = {"com.cursoee.hoteles.controller",
										   "com.cursoee.hoteles.service",
										   "com.cursoee.hoteles.lanzador"})
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
