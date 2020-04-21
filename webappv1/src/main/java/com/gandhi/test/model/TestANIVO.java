package com.gandhi.test.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TestANIVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	String tranOpt;
	
	@NotNull
	String cardBrand;
	
	@NotNull
	int cardToProcess;
	
	public TestANIVO() {
		super();
	}

	public String getTranOpt() {
		return tranOpt;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public int getCardToProcess() {
		return cardToProcess;
	}

	public void setTranOpt(String tranOpt) {
		this.tranOpt = tranOpt;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public void setCardToProcess(int cardToProcess) {
		this.cardToProcess = cardToProcess;
	}
	
}
