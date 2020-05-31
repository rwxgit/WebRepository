package com.gandhi.springweb.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ConsentId", "Initiation" })
public class Data {

	@JsonProperty("ConsentId")
	private String consentId;
	@JsonProperty("Initiation")
	private Initiation initiation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ConsentId")
	public String getConsentId() {
		return consentId;
	}

	@JsonProperty("ConsentId")
	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}

	@JsonProperty("Initiation")
	public Initiation getInitiation() {
		return initiation;
	}

	@JsonProperty("Initiation")
	public void setInitiation(Initiation initiation) {
		this.initiation = initiation;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
