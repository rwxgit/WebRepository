package com.gandhi.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControl {
	
	@RequestMapping(value= {"/", "home"}, method=RequestMethod.GET)
	public String showMenu() {
		System.out.println("Control comes to HomeControl class and displays the index page");
		return "index";
	}

}