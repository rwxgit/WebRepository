package com.gandhi.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value= {"/testing"}, method=RequestMethod.GET)
	public String showTestPage() {
		System.out.println("control in the testing page");
		return "testing";
	}
		

}
