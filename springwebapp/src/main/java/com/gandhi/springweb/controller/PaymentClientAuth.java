package com.gandhi.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/payments/callback")
public class PaymentClientAuth {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showMenu() {
		System.out.println("Control comes to callback method for authorization request");
		return "index";
	}

}