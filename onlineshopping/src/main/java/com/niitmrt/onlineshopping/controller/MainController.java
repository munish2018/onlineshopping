package com.niitmrt.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value={"/","/home","index"})
	public ModelAndView  vw1()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting"," welcome to online shopping ");
		return mv;
	}
	
}
 