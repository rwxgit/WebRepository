package com.gandhi.springweb.util;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestJunit {
	
	@Test
	public void testGetJsonFromFile() throws IOException {
		String fileName = "consentrequest.json";
		String jsonContent = JsonUtility.getJsonFromFile(fileName);
		System.out.println(jsonContent);
	}
	
}
