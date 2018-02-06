package com.niitmrt.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niitmrt.shoppingbackend.dao.CategoryDAO;
import com.niitmrt.shoppingbackend.dao.UserDAO;
import com.niitmrt.shoppingbackend.model.User;

@Controller
public class MainController {
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private UserDAO userDAO;
	
	@RequestMapping(value={"/"})
	public ModelAndView vwindex()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("index");
		obj.addObject("title","Home");
		obj.addObject("userClickHome",true);
		return obj;
	}

	@RequestMapping(value={"/register"})
	public ModelAndView vwregis()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("register");
		obj.addObject("title","Register");
		obj.addObject("userClickRegister",true);
		return obj;
	}
	
	@RequestMapping(value={"/signin"})
	public ModelAndView vwsignin()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("signin");
		obj.addObject("title","SignIn");
		obj.addObject("userClickSignIn",true);
		return obj;
	}

	@RequestMapping(value={"/aboutus"})
	public ModelAndView vwaboutus()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("aboutus");
		obj.addObject("title","AboutUs");
		obj.addObject("userClickAboutUs",true);
		return obj;
	}
	
	@RequestMapping(value={"/contactus"})
	public ModelAndView vwcontactus()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("contactus");
		obj.addObject("title","ContactUs");
		obj.addObject("userClickContactUs",true);
		return obj;
	}

	@RequestMapping(value={"/admin"})
	public ModelAndView vwadmin()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("admin");
		obj.addObject("title","Admin");
		obj.addObject("userClickAdmin",true);
		return obj;
	}
	
	@PostMapping("/userdetsave")
	public String savesudet(@ModelAttribute("udet") User udet, HttpServletRequest request) {
		System.out.println("  User Detail  save ");
		System.out.println("user id :" + udet.getId());
		System.out.println("user name :" + udet.getFirstName());
		userDAO.add(udet);
		return "redirect:/";
	}
	
}
 