package com.gandhi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.FormatTraceVO;

@Controller
public class FormatTraceControl {

	@RequestMapping(value="parsetrace", method=RequestMethod.GET)
	public ModelAndView showParseTraceForm() {
		return new ModelAndView("FormatTracePage", "formattraceMVbinder", new FormatTraceVO());
	}
	
}