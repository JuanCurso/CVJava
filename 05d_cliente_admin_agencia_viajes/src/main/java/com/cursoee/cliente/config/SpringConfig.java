package com.cursoee.cliente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.cursoee.cliente.service")
public class SpringConfig {
	@Bean
	public RestTemplate template() {
		//crear encabezado de autorización a través de un interceptor
		RestTemplate template = new RestTemplate();
		BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("user1", "user1");
		template.getInterceptors().add(interceptor);
		return template;
	}
}
