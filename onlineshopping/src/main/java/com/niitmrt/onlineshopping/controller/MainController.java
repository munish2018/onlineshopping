package com.niitmrt.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value={"/"})
	public ModelAndView vwindex()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("index");
		return obj;
	}

	@RequestMapping(value={"/register"})
	public ModelAndView vwregis()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("register");
		return obj;
	}
	
	@RequestMapping(value={"/signin"})
	public ModelAndView vwsignin()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("signin");
		return obj;
	}

	@RequestMapping(value={"/aboutus"})
	public ModelAndView vwaboutus()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("aboutus");
		return obj;
	}
	
	@RequestMapping(value={"/contactus"})
	public ModelAndView vwcontactus()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("contactus");
		return obj;
	}

	
}
 