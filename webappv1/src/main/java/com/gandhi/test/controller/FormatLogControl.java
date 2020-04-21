package com.gandhi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.FormatLogVO;

@Controller
public class FormatLogControl {

	@RequestMapping(value="parselog", method=RequestMethod.GET)
	public ModelAndView showParseLogForm() {
		return new ModelAndView("FormatLogPage", "formatlogMVbinder", new FormatLogVO());
	}

}
