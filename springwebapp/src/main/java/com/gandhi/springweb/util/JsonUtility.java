package com.gandhi.springweb.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
	
	private static String jsonString;
	private static ObjectMapper defaultObjectMapper;
	
	public static String getJsonFromFile(String fileName) throws IOException {
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		jsonString = new String(Files.readAllBytes(file.toPath()));
		
		return jsonString;
	}
	
	public static ObjectMapper getDefauttObjectMapper() {
		
		defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
		
	}
	
	public static JsonNode parseJson(String jsonString) throws IOException {
		
		JsonNode rootNode = defaultObjectMapper.readTree(jsonString);
		return rootNode;
	}
}
