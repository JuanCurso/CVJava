package com.cursoee.reservas.lanzador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter{
	
	//clave utilizada en la firma
		@Value("${application.jwtSigningKey}")
		private String signingKey;	
		@Override
		public void configure(ResourceServerSecurityConfigurer config) {
		    config.resourceId("default-resources"); // coincide con el resourceId del servidor de autorización
		    config.tokenServices(this.getTokenService());
		}
		@Bean
		// se encarga de la verificación de token
		public JwtAccessTokenConverter jwtTokenConverter() {
		    final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		    converter.setSigningKey(signingKey);
		    return converter;
		}
		//genera el TokenStore  a partir del converter
		@Bean
		public TokenStore jwtTokenStore() {
		    return new JwtTokenStore(this.jwtTokenConverter());
		}
		
		//servicio de tokens encargado de la verificación del token recibido
		@Bean
		@Primary
		public DefaultTokenServices getTokenService() {
		    final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		    defaultTokenServices.setTokenStore(this.jwtTokenStore());
		    return defaultTokenServices;
		}
	
	
	//configuración Web
	@Override  
	public void configure(HttpSecurity http) throws Exception {	  
		http
		  .authorizeRequests()	      
		  .antMatchers(HttpMethod.GET,"/reservas/*").hasRole("ADMIN");
	}
}
