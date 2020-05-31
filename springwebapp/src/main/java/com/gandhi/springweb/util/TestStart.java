package com.gandhi.springweb.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestStart {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		//TestStart.testString();
		
		//TestStart.testJson();
		
		//TestStart.deleteJsonNode();
		
		TestStart.deleteJsonNode1();
		
		System.out.println("program completed");
		
	}
	
	private static void deleteJsonNode1() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "{\"Data\":{\"ConsentId\":\"81c28a1c-c3bf-49af-b4c2-45ef5ca74801\",\"CreationDateTime\":\"2020-05-09T10:08:17.080Z\",\"Status\":\"AwaitingAuthorisation\",\"StatusUpdateDateTime\":\"2020-05-09T10:08:17.098Z\",\"Initiation\":{\"InstructionIdentification\":\"instr-identification\",\"EndToEndIdentification\":\"e2e-identification\",\"InstructedAmount\":{\"Amount\":\"50.00\",\"Currency\":\"GBP\"},\"CreditorAccount\":{\"SchemeName\":\"IBAN\",\"Identification\":\"BE56456394728288\",\"Name\":\"ACME DIY\",\"SecondaryIdentification\":\"secondary-identif\"},\"RemittanceInformation\":{\"Unstructured\":\"Tools\",\"Reference\":\"Tools\"}}},\"Risk\":{\"PaymentContextCode\":\"EcommerceGoods\"},\"Links\":{\"Self\":\"https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payment-consents/81c28a1c-c3bf-49af-b4c2-45ef5ca74801\"},\"Meta\":{\"TotalPages\":1}}";
		ObjectNode objectNode = (ObjectNode) objectMapper.readTree(jsonString);
		System.out.println("rootNode value is ==> " + objectNode.toString());
		
		for (JsonNode node : objectNode) {
            ((ObjectNode)node).remove("CreationDateTime");
            ((ObjectNode)node).remove("Status");
            ((ObjectNode)node).remove("StatusUpdateDateTime");
        }
		
		objectNode.remove("Links");
		objectNode.remove("Meta");
		
		
		String consentId = objectNode.path("Data").path("ConsentId").asText();
		System.out.println("consentId value is ==> " + consentId);
		
		System.out.println("rootNode value is ==> " + objectNode.toString());

		
	}
	
	private static void deleteJsonNode() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "{\"Data\":{\"ConsentId\":\"81c28a1c-c3bf-49af-b4c2-45ef5ca74801\",\"CreationDateTime\":\"2020-05-09T10:08:17.080Z\",\"Status\":\"AwaitingAuthorisation\",\"StatusUpdateDateTime\":\"2020-05-09T10:08:17.098Z\",\"Initiation\":{\"InstructionIdentification\":\"instr-identification\",\"EndToEndIdentification\":\"e2e-identification\",\"InstructedAmount\":{\"Amount\":\"50.00\",\"Currency\":\"GBP\"},\"CreditorAccount\":{\"SchemeName\":\"IBAN\",\"Identification\":\"BE56456394728288\",\"Name\":\"ACME DIY\",\"SecondaryIdentification\":\"secondary-identif\"},\"RemittanceInformation\":{\"Unstructured\":\"Tools\",\"Reference\":\"Tools\"}}},\"Risk\":{\"PaymentContextCode\":\"EcommerceGoods\"},\"Links\":{\"Self\":\"https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payment-consents/81c28a1c-c3bf-49af-b4c2-45ef5ca74801\"},\"Meta\":{\"TotalPages\":1}}";
		JsonNode rootNode = objectMapper.readTree(jsonString);
		System.out.println("rootNode value is ==> " + rootNode.toString());
		
		for (JsonNode node : rootNode) {
            ((ObjectNode)node).remove("CreationDateTime");
            ((ObjectNode)node).remove("Status");
            ((ObjectNode)node).remove("StatusUpdateDateTime");
            ((ObjectNode)node).remove("Self");
            ((ObjectNode)node).remove("TotalPages");
            ((ObjectNode)node).remove("Links");
            ((ObjectNode)node).remove("Meta");
        }
		
		
		String consentId = rootNode.path("Data").path("ConsentId").asText();
		System.out.println("consentId value is ==> " + consentId);
		
		System.out.println("rootNode value is ==> " + rootNode.toString());
		
	}
	private static void testString() throws URISyntaxException {
		
		System.out.println("start of new testing");
		String urlString = "http://localhost:8080/payments/callback#code=88b51ff9-9fa0-4ec5-9d43-16db115c6d9b&id_token=eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IktobHVldWRvY1JrMlVCY0Q2TzBieklsUkhpSSJ9.eyJzdWIiOiJuYjQ1Qm5iblZYeExsTXFfNmVOMFBTNzZaNnB3NDdJemw4RkFISkltaHY4PSIsImFjciI6InVybjpvcGVuYmFua2luZzpwc2QyOnNjYSIsImF1ZCI6Im5iNDVCbmJuVlh4TGxNcV82ZU4wUFM3Nlo2cHc0N0l6bDhGQUhKSW1odjg9IiwiY19oYXNoIjoiSDFRUEhoNUxhWVRxU0NWVEhqYUsydyIsIm9wZW5iYW5raW5nX2ludGVudF9pZCI6ImYwMTRlYjJlLWUwYWYtNDk5NC05YWIzLWFlY2VlMzIxMGJjMyIsInNfaGFzaCI6InRkUUVYRDlHYjZrZjRzeHF2bmtqS2ciLCJpc3MiOiJyYnMudXNlaW5maW5pdGUuaW8iLCJleHAiOjE2MjA1NDQxNzIsInRva2VuX3R5cGUiOiJJRF9UT0tFTiIsImlhdCI6MTU4OTAwODE3MiwianRpIjoiMWRmNGQxODgtMWFmNy00MWMzLWFmMjktODRkY2U1ZDNhOTQ5In0.gGog9F6M5stckHQe326EHqtamutZzppn-qwbyFg8hW1_e8wvzOId4EONWsH6jZPSAuhcplQvF2VQxhNb_U9jrOR_2IZFvuWW7P4RGqLUkzedAg1FlzxpdBjF8QbIFlerjCYowLrA8AYUga_OofXKxGi9Y7oHCqc52f8pXW6grw60CDdgxsa5oTH7Fruf8PMtS54UpxhQRDqeojwPW2tvWn9bfoMNOLP8d-i6pNW-VW8um8mys-q2M-t4VyZkh4RRQ9otIqmw3T3YSFTp8gycLFb331ZQUqNBoDicaSje2Z1u6fcSs1dSyI_amjhYvtMvfJO5-ikEYdpPEqnUDen6lA&state=ABC";
		
		List<NameValuePair> list = URLEncodedUtils.parse(urlString, Charset.forName("UTF-8"));
		
		String tokenString = null;
		String stateString = null;
		String codeString = null;
		for (Iterator<NameValuePair> iterator = list.iterator(); iterator.hasNext();) {
			//NameValuePair nameValuePair = (NameValuePair) iterator.next();
			NameValuePair valueString = iterator.next();
			//System.out.println("NameValuePair is ==> " + valueString);
			System.out.println("name is  ==> " + valueString.getName());
			//System.out.println("value is ==> " + valueString.getValue()); 
			/*
			 * if (valueString.getName() == "id_token"){ tokenString =
			 * valueString.getValue(); }else if (valueString.getName() == "state") {
			 * stateString = valueString.getValue(); }else if
			 * (valueString.getName().contains("#code=") ) { codeString =
			 * valueString.getValue();
			 * 
			 * }
			 */
			
			if (valueString.getName().equals("id_token")){
				tokenString = valueString.getValue();
			}else if (valueString.getName().equals("state")) {
				stateString = valueString.getValue();
			}else if (valueString.getName().contains("#code")){
				codeString = valueString.getValue();
			}
			
		}
		
		System.out.println("value of tokenString is ==> " + tokenString);
		System.out.println("value of statestring is ==> " + stateString);
		System.out.println("value of code string is ==> " + codeString);
		
	}

	
	private static void testJson() throws IOException {
		
		System.out.println("********************************************************");
		System.out.println("start of json tree learning");
		System.out.println("POJO to JSON ==> Serialization");
		System.out.println("JSON to POJO ==> Desearialization");
		System.out.println("Jackson provides one of the best API's to support JSON");
		System.out.println("********************************************************");
		
		String fileName = "consentrequest.json";
		String jsonContent = JsonUtility.getJsonFromFile(fileName);
		System.out.println(jsonContent);
		
		JsonUtility.getDefauttObjectMapper();
		JsonNode rootNode = JsonUtility.parseJson(jsonContent);		
		
		System.out.println("rootNode as string ==>" + rootNode.toString());
		
		JsonNode initNode = rootNode.path("Initiation");
		System.out.println("initNode as string ==> " + initNode.toString());
		System.out.println("initNode as string ==> " + rootNode.path("Initiation").toString());
		System.out.println("dateNode as string ==> " + rootNode.path("CreationDateTime").toString());
		
		System.out.println("riskNode as string ==> " + rootNode.path("Risk").toString());
		System.out.println("linksNode as string ==> " + rootNode.path("Links").toString());
		System.out.println("MetaNode as string ==> " + rootNode.path("Meta").toString());
		
		JsonNode consentIdNode = rootNode.path("Data").path("ConsentId");
		System.out.println("ConsentId node as string ==> " + consentIdNode.asText());

		
	}
	
}
