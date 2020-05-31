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
@JsonPropertyOrder({ "InstructionIdentification", "EndToEndIdentification", "InstructedAmount", "CreditorAccount",
		"RemittanceInformation" })
public class Initiation {

	@JsonProperty("InstructionIdentification")
	private String instructionIdentification;
	@JsonProperty("EndToEndIdentification")
	private String endToEndIdentification;
	@JsonProperty("InstructedAmount")
	private InstructedAmount instructedAmount;
	@JsonProperty("CreditorAccount")
	private CreditorAccount creditorAccount;
	@JsonProperty("RemittanceInformation")
	private RemittanceInformation remittanceInformation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("InstructionIdentification")
	public String getInstructionIdentification() {
		return instructionIdentification;
	}

	@JsonProperty("InstructionIdentification")
	public void setInstructionIdentification(String instructionIdentification) {
		this.instructionIdentification = instructionIdentification;
	}

	@JsonProperty("EndToEndIdentification")
	public String getEndToEndIdentification() {
		return endToEndIdentification;
	}

	@JsonProperty("EndToEndIdentification")
	public void setEndToEndIdentification(String endToEndIdentification) {
		this.endToEndIdentification = endToEndIdentification;
	}

	@JsonProperty("InstructedAmount")
	public InstructedAmount getInstructedAmount() {
		return instructedAmount;
	}

	@JsonProperty("InstructedAmount")
	public void setInstructedAmount(InstructedAmount instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	@JsonProperty("CreditorAccount")
	public CreditorAccount getCreditorAccount() {
		return creditorAccount;
	}

	@JsonProperty("CreditorAccount")
	public void setCreditorAccount(CreditorAccount creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	@JsonProperty("RemittanceInformation")
	public RemittanceInformation getRemittanceInformation() {
		return remittanceInformation;
	}

	@JsonProperty("RemittanceInformation")
	public void setRemittanceInformation(RemittanceInformation remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
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
