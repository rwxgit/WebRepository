package com.gandhi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.TestCCNIVO;

@Controller
public class TestCCNIControl {

	@RequestMapping(value="testccni", method=RequestMethod.GET)
	public ModelAndView showTestCCNIForm() {
		return new ModelAndView("TestCCNIPage", "testccniMVbinder", new TestCCNIVO());
	}

}
