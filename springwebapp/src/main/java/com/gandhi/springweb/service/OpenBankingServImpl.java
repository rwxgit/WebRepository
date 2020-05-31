package com.gandhi.springweb.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gandhi.springweb.controller.tokenObject;
//import com.gandhi.springweb.model.AccessToken;
import com.gandhi.springweb.security.SslSettings;

@Service
public class OpenBankingServImpl {

	private static final String USER_ACCOUNT = "50000012345601";
	private static final String USER_NAME = "123456789012@atm.rbs.com";
	private static final String FINANCIAL_ID = "0015800000jfwB4AAI";
	private static final String REDIRECT_URI = "http://localhost:8080/payments/callback";
	private static final String AUTH_CODE = "code id_token";
	private static final String CLIENT_ID = "nb45BnbnVXxLlMq_6eN0PS76Z6pw47Izl8FAHJImhv8=";
	private static final String CLIENT_SECRET = "y-fBeVPS2Zq0rpfmoGiErHHOARKBIa8UAI83aPLHucM=";
	private static final String URL_0 = "https://api.rbs.useinfinite.io/.well-known/openid-configuration";
	private static final String URL_1 = "https://ob.rbs.useinfinite.io/token";	
	private static final String URL_2 = "https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payment-consents";
	private static final String URL_3 = "https://api.rbs.useinfinite.io/authorize";
	private static final String URL_4 = "https://ob.rbs.useinfinite.io/token";
	private static final String URL_5 = "https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payments";
	
	//private String idempString = "rajf9ff9-381d-4f02-952d-030bfb84e8c5";
	
	ResponseEntity<String> responseEntity;
		
	
	// @Autowired SslSettings sslSettings;
	
	public ResponseEntity<String> getWellKnownEndpoint() {

		RestTemplate restTemplate = new RestTemplate();
		responseEntity = restTemplate.exchange(URL_0, HttpMethod.GET, null, String.class);
	
		return responseEntity;
	}
	
	public ResponseEntity<String> getAccTokenforPayment() throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);	
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_1)
				.queryParam("grant_type", "client_credentials")
				.queryParam("client_id", CLIENT_ID)
				.queryParam("client_secret", CLIENT_SECRET)
				.queryParam("scope", "payments");
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();
		
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, entity, String.class);
		//responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class);

		return responseEntity;
	}
	
	public ResponseEntity<String> postPaymentConsentReq(String accessToken, String accessType) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		
		String token = accessType + " " + accessToken;
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		System.out.println("uuidString in post payment request is ==>" + uuidString);
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", token);
		headerMap.put("x-fapi-financial-id", FINANCIAL_ID);
		headerMap.put("x-jws-signature", "DUMMY_SIG");
		headerMap.put("x-idempotency-key", uuidString);
		headerMap.put("Content-Type", "application/json");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAll(headerMap);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_2);
		
		//Read JSON file into a string.
		String fileName = "requestDomestic2.json";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		String jsonContent = new String(Files.readAllBytes(file.toPath()));	
		
		HttpEntity<?> entity = new HttpEntity<>(jsonContent, headers);
		SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();	
				
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, entity, String.class);
		
		return responseEntity;
	}

	public ResponseEntity<String> approveConsentReq(String consentId) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_3)
	    		.queryParam("client_id", CLIENT_ID)
	    		.queryParam("response_type", AUTH_CODE)
	    		.queryParam("scope", "openid payments")
	    		.queryParam("redirect_uri", REDIRECT_URI)
	    		.queryParam("state", "ABC")
	    		.queryParam("request", consentId)
	    		.queryParam("authorization_mode", "AUTO_POSTMAN")
	    		.queryParam("authorization_username", USER_NAME)
	    		.queryParam("authorization_account", USER_ACCOUNT);
	    
	    HttpEntity<?> entity = new HttpEntity<>(headers);
	    
	    SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();
		
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, entity, String.class);
	    
		return responseEntity;
	}
	
	public ResponseEntity<String> exchangeAccessTokenforCode(String authCode) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_4)
				.queryParam("client_id", CLIENT_ID)
				.queryParam("client_secret", CLIENT_SECRET)
				.queryParam("redirect_uri", REDIRECT_URI)
				.queryParam("grant_type", "authorization_code")
				.queryParam("code", authCode);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();
		
		System.out.println("URI_4 value is ==> " + builder.build().toUri());
		
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, entity, String.class);

		return responseEntity;
	}
	
	public ResponseEntity<String> postPayment(String accessToken, String paymentRequest) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		
		String token = "Bearer " + accessToken;
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		System.out.println("uuidString in post payment request is ==>" + uuidString);
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", token);
		headerMap.put("x-fapi-financial-id", FINANCIAL_ID);
		headerMap.put("x-jws-signature", "DUMMY_SIG");
		headerMap.put("x-idempotency-key", uuidString);
		headerMap.put("Content-Type", "application/json");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAll(headerMap);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_5);	
		
		HttpEntity<?> entity = new HttpEntity<>(paymentRequest, headers);
		SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();	
				
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, entity, String.class);
		
		return responseEntity;
	}	
	
	public ResponseEntity<String> getDomesticPaymentStatus(String accessToken, String consentId) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException{
		
		String token = "Bearer " + accessToken;
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", token);
		headerMap.put("x-fapi-financial-id", FINANCIAL_ID);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAll(headerMap);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_5 + "/" + consentId);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		SslSettings sslSettings = new SslSettings();
		RestTemplate restTemplate = sslSettings.getRestTemplate();
		
		System.out.println("get payment status URI is ==> " + builder.build().toUri());
		
		responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, entity, String.class);

		return responseEntity;
	}
	
}

