package com.cursoee.cliente.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursoee.cliente.model.Reserva;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class ReservasServiceImpl implements ReservasService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String urlServidorAuth="http://localhost:11000/";
	@Value("${usuarioService}")
	String usuarioService;
	@Value("${pwdService}")
	String pwdService;
	@Value("${usuarioOauth2}")
	String usuarioOauth2;
	@Value("${pwdOauth2}")
	String pwdOauth2;

	
//	private String urlBase="http://localhost:10000/";
	private String urlBase="http://localhost:12000/sreservas/";

	@Override
	public List<Reserva> buscarReserva(String nombreHotel) {
		String token=obtenerToken();
		System.out.println("Token JWT: "+token);
		//creamos una cabecera que incluya el token
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers1);
		//enviamos petición al servicio destinatario y recogemos la respuesta
		ResponseEntity<Reserva[]> data = restTemplate.exchange(urlBase+"reservas/{n}", HttpMethod.GET, entity, Reserva[].class, nombreHotel);	
		return Arrays.asList(data.getBody());
		// TODO Meter el control de errores comprobando la cabecera
		//return Arrays.asList(restTemplate.getForObject(urlBase+"reservas/{n}", Reserva[].class, nombreHotel));
	}
	
	private String obtenerToken() {
		//agregamos credenciales para autenticarnos con el servidor de autenticación a cabecera
		String credentials = usuarioOauth2+":"+pwdOauth2;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		headers.add("Authorization", "Basic " + encodedCredentials);
		//construimos objeto HttEntity y solicitamos el token al servidor		
		HttpEntity<String> request = new HttpEntity<String>(headers);		
		String access_token_url = urlServidorAuth+"oauth/token";
		access_token_url += "?grant_type=password";
		access_token_url += "&username="+usuarioService;
		access_token_url += "&password="+pwdService;
		//petición al servidor de autorización
		ResponseEntity<String> response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(response.getBody());
			return node.path("access_token").asText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
