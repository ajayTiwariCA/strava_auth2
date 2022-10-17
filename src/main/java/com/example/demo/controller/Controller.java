package com.example.demo.controller;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/test")
	public ResponseEntity<String> test(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+client.getAccessToken().getTokenValue());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = ResponseEntity.ok()
				.headers(headers)
				.body("this is test controller");

		return response;
	}
	
}
