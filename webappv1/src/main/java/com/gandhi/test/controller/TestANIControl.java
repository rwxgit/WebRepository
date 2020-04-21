package com.gandhi.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandhi.test.model.MenuOptList;
import com.gandhi.test.model.TestANIVO;

@Controller
public class TestANIControl {

	private MenuOptList menuOptList = new MenuOptList();
	
	/*@RequestMapping(value="testani", method=RequestMethod.GET)
	public ModelAndView showTestANIForm(@ModelAttribute  TestANIVO testANIVO, Model model) {
		model.addAttribute("tranOptList", this.gettranOptList());
		return new ModelAndView("TestANIPage", "testaniMVbinder", new TestANIVO());
		
	}*/
	
	@RequestMapping(value="testani", method=RequestMethod.GET)
	public String showTestANIForm(@ModelAttribute("testaniMVbinder") TestANIVO testANIVO,
								  Model model) {
		//TestANIVO testANIVO = new TestANIVO();
		//ModelAndView mav = new ModelAndView("TestANIPage", "testaniMVbinder", testANIVO);
		//mav.addObject("tranOptList", this.gettranOptList());
		model.addAttribute("tranOptList", menuOptList.gettranOptList() );
		model.addAttribute("cardBrandList", menuOptList.getcardBrandList() );
		model.addAttribute("cardOptList", menuOptList.getcardOptList());
		return "TestANIPage";
	}
	
	/*public String showTestANIForm(@ModelAttribute("testaniMVbinder") TestANIVO testANIVO,
			  Model model) {
			//TestANIVO testANIVO = new TestANIVO();
			//ModelAndView mav = new ModelAndView("TestANIPage", "testaniMVbinder", testANIVO);
			//mav.addObject("tranOptList", this.gettranOptList());
			model.addAttribute("tranOptList", menuOptList.gettranOptList() );
			model.addAttribute("cardBrandList", menuOptList.getcardBrandList() );
			model.addAttribute("cardOptList", menuOptList.getcardOptList());
			return "TestANIPage";
	}*/
	/*public ModelAndView showTestANIForm() {
		TestANIVO testANIVO = new TestANIVO();
		ModelAndView mav = new ModelAndView("TestANIPage", "testaniMVbinder", testANIVO);
		//mav.addObject("tranOptList", this.gettranOptList());
		mav.addObject("tranOptList", menuOptList.gettranOptList() );
		mav.addObject("cardBrandList", menuOptList.getcardBrandList() );
		mav.addObject("cardOptList", menuOptList.getcardOptList());
		return mav;
	}*/
	
	@RequestMapping(value="testani", method=RequestMethod.POST)
	public String submitForm(@Valid TestANIVO testANIVO, 
							 BindingResult result,
							 Model model) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			System.out.println("form posting has errors");
			model.addAttribute("tranOptList", menuOptList.gettranOptList() );
			model.addAttribute("cardBrandList", menuOptList.getcardBrandList() );
			model.addAttribute("cardOptList", menuOptList.getcardOptList());
			return "TestANIPage";
			//return showTestANIForm(testANIVO, model);
		}else {
			return "Test";
		}
		
	}
	
	/*public String submitForm(@Valid @ModelAttribute("testaniMVbinder")TestANIVO testANIVO, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			System.out.println("form posting has errors");
			return "TestANIPage";
		}else {
			return "Test";
		}
		
	}*/
	/*public String submitForm(@ModelAttribute("testaniMVbinder")TestANIVO testANIVO, BindingResult result) {
		return "TestANIPage";
	}*/
	
}
