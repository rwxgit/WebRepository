package com.gandhi.springweb.controller;

import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gandhi.springweb.model.SampleDao;

@Controller
@RequestMapping(value = "/testApiOld")
public class RestClient1 {

	/* @GetMapping(value = "/callback") */
	@RequestMapping(method = RequestMethod.GET)
	public String authCodeCallbak() {
		System.out.println("Control comes to testAPI page");

		/*
		 * 1. call the authorization server
		 * 2. control has to reach callback endpoint
		 * 3. from the call back endpoint send the request to the token endpoint
		 * 4. receive the response and once successful, then send the request to the resource endpoint
		 * 5. receive the response and update the UI and respond to the user.
		 * 
		*/
		
		String weatherResourcUrl_0 = "http://api.openweathermap.org/data/2.5/weather";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherResourcUrl_0)
				.queryParam("q", "delhi")
				.queryParam("appid", "3b0e648a1c27382ff83e03d7bf60f28a");
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response1 = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		
		System.out.println("http status for api request ==> " + response1.getStatusCode().toString());
		if (response1.getStatusCode() != HttpStatus.OK){
			System.out.println("the authorisation request failed. Respond to user appropriately");
			return "testAPI";
		}
		System.out.println("The result value for Url_0 is ===> " + response1.getBody());
		
		
		String testUri = "https://jsonplaceholder.typicode.com/todos/1";
		ResponseEntity<String> response2 = restTemplate.exchange(testUri, HttpMethod.GET, null, String.class);
		System.out.println("The result value for Url_2 is  ==> " + response2.getBody());
		
		ObjectMapper objectMapper = new ObjectMapper();
		SampleDao jsonObject = null;
		try {
			jsonObject = objectMapper.readValue(response2.getBody(), SampleDao.class);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("value of userid ==>" +  jsonObject.userId 
												+ " " + jsonObject.title 
												+ " " + jsonObject.id
												+ " " + jsonObject.completed);
		System.out.println("value of different properties ==>" +  jsonObject.getAdditionalProperties());
		
		/*
		 * HttpHeaders httpHeaders = new HttpHeaders();
		 * httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * HttpEntity<String> entity = new HttpEntity<String>("parameters",
		 * httpHeaders); ResponseEntity<String> response =
		 * restTemplate.exchange(weatherResourcUrl, HttpMethod.GET, entity,
		 * String.class);
		 */

		
		/*
		 * HttpHeaders httpHeaders = new HttpHeaders(); httpHeaders.set("Accept",
		 * MediaType.APPLICATION_JSON);
		 * httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); String
		 * weatherResourcUrl_1 = "http://api.openweathermap.org/data/2.5/weather";
		 * UriComponentsBuilder builder =
		 * UriComponentsBuilder.fromHttpUrl(weatherResourcUrl_1) .queryParam("q",
		 * "delhi") .queryParam("appid", "3b0e648a1c27382ff83e03d7bf60f28a");
		 * 
		 * System.out.println("built uri ==> " + builder.
		 * 
		 * RestTemplate restTemplate = new RestTemplate(); String weatherResourcUrl =
		 * "http:/api.openweathermap.org/data/2.5/weather?q=delhi&appid=3b0e648a1c27382ff83e03d7bf60f28a";
		 * ResponseEntity<String> response =
		 * restTemplate.getForEntity(weatherResourcUrl, String.class);
		 * System.out.println("response Entity value ==> " + response.toString());
		 */
		 
		
		return "testAPI";
	}

}
