package com.gandhi.springweb.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResponseDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String testName;
	private List<String> responseList;
	private Map<String, String> responseMap;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public List<String> getResponseList() {
		return responseList;
	}
	public void setResponseList(List<String> responseList) {
		this.responseList = responseList;
	}
	public Map<String, String> getResponseMap() {
		return responseMap;
	}
	public void setResponseMap(Map<String, String> responseMap) {
		this.responseMap = responseMap;
	}	
	
	
}
