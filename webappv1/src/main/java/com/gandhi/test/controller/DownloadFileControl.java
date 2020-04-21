package com.gandhi.test.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.ApplicationContext;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.DownloadFileVO;
import com.gandhi.test.model.MenuOptList;
import com.gandhi.test.service.DownloadFileService;
//import com.gandhi.test.service.logging.ATMDevLogFactory;
//import com.gandhi.test.service.logging.ATMDevLogger;
//import com.gandhi.test.service.logging.IATMDevLogger;

@Controller
public class DownloadFileControl{
	
	private MenuOptList menuOptList = new MenuOptList();
	private String l_ipValue;  //stores the ip address value
	private String l_remoteFile;
	private String l_localFile;
	//static Logger log = Logger.getLogger(DownloadFileControl.class);
	//private static IATMDevLogger log = ATMDevLogFactory.getLog(DownloadFileControl.class); 
	
	@RequestMapping(value="downloadfile", method=RequestMethod.GET)
	/*public String showDownloadfileForm(@ModelAttribute("downloadMVbinder")
										@Valid DownloadFileVO dowloadFileVO,
										Model model) {*/
	public String showDownloadfileForm(@ModelAttribute("downloadMVbinder")
										@Valid DownloadFileVO dowloadFileVO,
										BindingResult bindingResult,
										Model model) {
		/*
		 * these log statements are used by the log4j log application
		 * This is replaced by the RBSG application framework. RJAF
		 * 
		log.trace("Hello World!");
		log.debug("How are you today?");
		log.info("I am fine.");DownloadFileVO
		log.error("I am programming.");
		log.warn("I love programming.");
		log.fatal("I am now dead. I should have been a movie star.");*/
		final String METHODNAME = "showDownloadfileForm";
		//log.methodEntry(METHODNAME);
		model.addAttribute("hostList", menuOptList.gethostList());
		//log.methodExit(METHODNAME);
		return "DownloadfilePage";
	}
	
	/*public ModelAndView showDownloadfileForm() {
		return new ModelAndView("DownloadfilePage", "downloadMVbinder", new DownloadFileVO());
	}*/
	
	@RequestMapping(value="downloadfile", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("downloadMVbinder") 
							 @Valid DownloadFileVO downloadFileVO,
							 BindingResult bindingResult,
							 Model model) {
		/* 
		 * 1. validate the input received from html form 
		 * 2. once validation is successful, then call the module 
		 * 
		 * */
		System.out.println("Binding result object value ==> " + bindingResult.toString());
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DownloadFileVO>> constraintViolations = validator.validate(downloadFileVO);
		System.out.println("Constrain Violation object value ==>" + constraintViolations.toString());
		
		System.out.println("Model object value ==> " + model.toString());
		System.out.println("Model object value ==> " + downloadFileVO.toString());
		
		if (bindingResult.hasErrors()){
			
	            return "DownloadfilePage"; //it returns the error messages to the same page
	        
		}
			
		boolean error = false;
		
		
		
		error = this.formValidation(error, downloadFileVO, bindingResult);
		
		if(error) {
			model.addAttribute("hostList", menuOptList.gethostList());
			return "DownloadfilePage";
		}
		
		/*
		 * Once the data is validated, then the data is used to get the ftp done.
		 * The FTP functionality is done by DownloadFileService.
		 */
		
		try {
			DownloadFileService ftpDownloader = 
					new DownloadFileService(
							l_ipValue, 
							downloadFileVO.getUserName(), 
							downloadFileVO.getPassword());
			ftpDownloader.downloadFile(
					l_remoteFile, 
					l_localFile);
            System.out.println("FTP File download process completed");
            ftpDownloader.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*return "redirect:success";*/
		
		model.addAttribute("hostList", menuOptList.gethostList());
		return "DownloadfilePage";
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model){
         return "SuccessPage";
    }
	
	private boolean formValidation(boolean error,
									DownloadFileVO downloadFileVO,
									BindingResult bindingResult) {

		/*		use this below validation framework in the future
		 * 
		* http://java.candidjava.com/tutorial/Spring-mvc-custom-validator-annotation-with-constraintvalidator-example-interface-using-maven-and-eclipse.htm
		* 
		*/
			
		System.out.println("Ip Address is ==> " + downloadFileVO.getIpAddress());
		if (downloadFileVO.getIpAddress().isEmpty() || downloadFileVO.getIpAddress() == "NONE") {
			bindingResult.rejectValue("ipAddress", "error.ipAddress");
			error = true;
		}

		//search hashmap to get the associated ip address value for the host
		l_ipValue = menuOptList.gethostList1().get(downloadFileVO.getIpAddress());
		System.out.println("Ip address for " + downloadFileVO.getIpAddress() + " " + l_ipValue );
		
		//validate username
		System.out.println("Username is ==> " + downloadFileVO.getUserName());
		if (downloadFileVO.getUserName().isEmpty()) {
			bindingResult.rejectValue("userName", "error.userName");
			error= true;
		}
		
		
		
		System.out.println("Password is ==> " + downloadFileVO.getPassword());
		if (downloadFileVO.getPassword().isEmpty()) {
			bindingResult.rejectValue("password", "error.password");
			error= true;
		}
		
		System.out.println("File name is ==> " + downloadFileVO.getFileName());
		if (downloadFileVO.getFileName().isEmpty()) {
			bindingResult.rejectValue("fileName", "error.fileName");
			error= true;
		}
		l_remoteFile = "'" + downloadFileVO.getFileName() + "'";
		
		System.out.println("Windows Path is ==> " + downloadFileVO.getWindowsPath());
		if (downloadFileVO.getWindowsPath().isEmpty()) {
			bindingResult.rejectValue("windowsPath", "error.windowsPath");
			error= true;
		}
		l_localFile = "C:\\ftp\\" + downloadFileVO.getWindowsPath();
		
		return error;
	}
}
