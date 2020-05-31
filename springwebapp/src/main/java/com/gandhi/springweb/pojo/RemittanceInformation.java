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
@JsonPropertyOrder({ "Unstructured", "Reference" })
public class RemittanceInformation {

	@JsonProperty("Unstructured")
	private String unstructured;
	@JsonProperty("Reference")
	private String reference;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Unstructured")
	public String getUnstructured() {
		return unstructured;
	}

	@JsonProperty("Unstructured")
	public void setUnstructured(String unstructured) {
		this.unstructured = unstructured;
	}

	@JsonProperty("Reference")
	public String getReference() {
		return reference;
	}

	@JsonProperty("Reference")
	public void setReference(String reference) {
		this.reference = reference;
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