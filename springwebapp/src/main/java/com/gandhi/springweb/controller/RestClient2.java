package com.gandhi.springweb.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gandhi.springweb.model.AccessToken;
import com.gandhi.springweb.model.AccessToken2;
import com.gandhi.springweb.model.ResponseDao;
import com.gandhi.springweb.service.OpenBankingServImpl;

@Controller
@RequestMapping(value = "/testApi")
public class RestClient2 {

	@Autowired
	OpenBankingServImpl openBankingServImpl;

	private AccessToken tokenObject = null;
	private AccessToken2 tokenObject2 = null;
	private String paymentConsentResponseJson;
	private String paymentRequetJsonString;
	private String consentId;
	private String approveConsentResponejson;

	@RequestMapping(method = RequestMethod.GET)
	public String getinfo(@ModelAttribute("restClient2MVbinder")
								ResponseDao responseDao,
								BindingResult bindingResult,
								Model model) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException {

		HashMap<String, String> responseMap = new HashMap<>();
		List<String> responseList = new ArrayList<>();
		System.out.println("value of name property in the bean is ==> " + responseDao.getTestName());
		ResponseEntity<String> responseEntity = openBankingServImpl.getWellKnownEndpoint();
		//System.out.println("response of first call ==> " + responseEntity.getStatusCode().toString());

		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			return "testAPI";
		}
		
		//logic to add the response into hashmap and send the information to the front end.
		//responseMap.put("entity request", "entity value");
		
		responseMap.put("payment request response", "consent value");

		responseEntity = openBankingServImpl.getAccTokenforPayment();	
		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			return "testAPI";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		tokenObject = objectMapper.readValue(responseEntity.getBody(), AccessToken.class);
		System.out.println("value of access token is ==> " + tokenObject.getAccessToken());
		
		
		responseEntity = openBankingServImpl.postPaymentConsentReq(tokenObject.getAccessToken(), tokenObject.getTokenType());
		if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
			return "testAPI";
		}
		
		System.out.println("Response of - Post Domestic payment consent ==> " + responseEntity.getBody());
		paymentConsentResponseJson = responseEntity.getBody();
		responseMap.put("payment consent request response", paymentConsentResponseJson);
		responseList.add(paymentConsentResponseJson);
		
		Object jsonObject1 =  objectMapper.readValue(responseEntity.getBody(), Object.class);
		String indendedString1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject1);
		System.out.println("************************* beautified response of payment consent requst is ******************************");
		System.out.println(indendedString1);
		System.out.println("*********************************************************************************************************");
		
		
		JsonNode rootNode = objectMapper.readTree(paymentConsentResponseJson);
		consentId = rootNode.path("Data").path("ConsentId").asText();
		System.out.println("consentId value is ==> " + consentId);
		
		responseEntity = openBankingServImpl.approveConsentReq(consentId);
		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			return "testAPI";
		}
		
		System.out.println("Response of - Authorize consent request programatically ==> " + responseEntity.getBody());
		approveConsentResponejson = responseEntity.getBody();
		JsonNode rootNode2 = objectMapper.readTree(approveConsentResponejson);
		String redirectUriString = rootNode2.path("redirectUri").asText();
		System.out.println("redirected URI string is ==> " + redirectUriString);
		
		List<NameValuePair> list = URLEncodedUtils.parse(redirectUriString, Charset.forName("UTF-8"));
		String codeString = null;
		for (Iterator<NameValuePair> iterator = list.iterator(); iterator.hasNext();) {
			
			NameValuePair valueString = iterator.next();
			
			if (valueString.getName().contains("#code")){
				codeString = valueString.getValue();
				break;
			}
			
		}
		System.out.println("value of code string is ==> " + codeString);
		
		responseEntity = openBankingServImpl.exchangeAccessTokenforCode(codeString);
		System.out.println("exchange auth code to token response body ==> " + responseEntity.getBody());
		
		tokenObject2 = objectMapper.readValue(responseEntity.getBody(), AccessToken2.class);
		//System.out.println("value of access token is ==> " + tokenObject2.getAccessToken());
		//System.out.println("value of refresh token is ==> " + tokenObject2.getRefreshToken());
		//System.out.println("value of id token is ==> " + tokenObject2.getIdToken());
		
		System.out.println("Process completed till approving consent programatically");
		
		paymentRequetJsonString = paymentConsentResponseJson;
		ObjectNode requestNode = (ObjectNode) objectMapper.readTree(paymentRequetJsonString);
		for (JsonNode node : requestNode) {
            ((ObjectNode)node).remove("CreationDateTime");
            ((ObjectNode)node).remove("Status");
            ((ObjectNode)node).remove("StatusUpdateDateTime");
        }
		
		requestNode.remove("Links");
		requestNode.remove("Meta");
		
		System.out.println("the value of the request payload is ==> " + requestNode.toString());
		
		responseEntity = openBankingServImpl.postPayment(tokenObject2.getAccessToken(), requestNode.toString());
		if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
			return "testAPI";
		}
		System.out.println("Response of - Post Domestic payment request ==> " + responseEntity.getBody());
		
		
		responseEntity = openBankingServImpl.getDomesticPaymentStatus(tokenObject2.getAccessToken(), consentId);
		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			return "testAPI";
		}
		System.out.println("Response of - Get payment status ==> " + responseEntity.getBody());
		
		Object jsonObject =  objectMapper.readValue(responseEntity.getBody(), Object.class);
		String indendedString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		System.out.println("************************* beautified final status of payment request is *********************************");
		System.out.println(indendedString);
		System.out.println("*********************************************************************************************************");
		
		responseMap.put("payment request response", indendedString);
		responseList.add(indendedString);
		
		System.out.println("Final step in getting the payment status completed successfully");
		
		responseDao.setTestName("gandhi is testing the model view binding");
		responseDao.setResponseList(responseList);
		responseDao.setResponseMap(responseMap);
		//model.addAttribute("message", "Hello Spring MVC Framework!");
		return "testing";
	}
	
	
}
