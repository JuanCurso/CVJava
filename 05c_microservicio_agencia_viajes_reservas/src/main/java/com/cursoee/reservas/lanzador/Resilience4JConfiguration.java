package com.cursoee.reservas.lanzador;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
@Configuration
public class Resilience4JConfiguration {
	CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
			.slidingWindowType(SlidingWindowType.COUNT_BASED) //no es necesario indicarlo, ya que por defecto se usa el circuito por contador
			.failureRateThreshold(50) //si el 50 por ciento de los intentos considerados fallan, entonces se abre el circuito
			.waitDurationInOpenState(Duration.ofMillis(30000)) //una vez que el circuito se abre, tiempo que espera antes de volver a intentar
			.slidingWindowSize(6)	//número de intentos que se consideran para abrir o cerrar el circuito		  
			.build();
	
//	CircuitBreakerConfig circuit1BreakerConfig = CircuitBreakerConfig.custom()
//			.slidingWindowType(SlidingWindowType.COUNT_BASED) //no es necesario indicarlo, ya que por defecto se usa el circuito por contador
//			.failureRateThreshold(10) //si el 50 por ciento de los intentos considerados fallan, entonces se abre el circuito
//			.waitDurationInOpenState(Duration.ofMillis(30000)) //una vez que el circuito se abre, tiempo que espera antes de volver a intentar
//			.slidingWindowSize(20) //número de intentos que se consideran para abrir o cerrar el circuito		  
//			.build();
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

		// configuración global
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(circuitBreakerConfig)
				.build());



	}

//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> circuit1CustomConfiguration() {
//		//configuración específica para un determinado circuit breaker
//		return factory -> factory.configure(builder -> builder
//				.circuitBreakerConfig(circuit1BreakerConfig)
//				.build(), "circuit1");
//	}
}
