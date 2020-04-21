package com.gandhi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.DownloadFilesVO;

@Controller
public class DownloadFilesControl {

	@RequestMapping(value="downloadfiles", method=RequestMethod.GET)
	public ModelAndView showDownloadfilesForm() {
		return new ModelAndView("DownloadfilesPage", "downloadsMVbinder", new DownloadFilesVO());
	}

}
