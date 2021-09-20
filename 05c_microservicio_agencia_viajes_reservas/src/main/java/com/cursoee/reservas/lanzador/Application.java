package com.cursoee.reservas.lanzador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = "com.cursoee.reservas.dao")
@EntityScan(basePackages = "com.cursoee.reservas.model")
@SpringBootApplication(scanBasePackages = {"com.cursoee.reservas.controller",
										   "com.cursoee.reservas.service",
										   "com.cursoee.reservas.lanzador"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
}
