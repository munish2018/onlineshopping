package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.dao.SupplierDAO;
import com.dao.UserDAO;
import com.model.Product;
import com.model.User;

@Controller
public class MainController {
	
	@Autowired 
	private UserDAO userDAO;
	
	@Autowired
	SupplierDAO s;

	@Autowired
	CategoryDAO c;

	@Autowired
	ProductDAO p;
	
	@RequestMapping(value={"/"})
	public ModelAndView vwindex()
	{
		ModelAndView obj = new ModelAndView();
		obj.setViewName("index");
		obj.addObject("title","Home");
		obj.addObject("cates", c.list());
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
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
		return "index";
	}
	
	@RequestMapping("/gotologin")
	public String log()
	{
			   return "login";
	}
	@RequestMapping("/login")
	public String logg()
	{
			   return "login";
	}
	@RequestMapping("/loginsuccess")
	public String loginsuccess(HttpSession httpSession) {
			httpSession.setAttribute("loggedIn", true);
			ModelAndView mv = new ModelAndView();
			mv.addObject("cates", c.list());
			return "index";
	}

	@RequestMapping("/logout")
	public String logou(HttpSession httpSession)
	{
		httpSession.setAttribute("loggedIn", false);
		return "index";
	}
	
	@RequestMapping("/error")
	public String err()
	{
		return "error";
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
	@RequestMapping(value={"/access-denied"})
	public ModelAndView accessDenied()
	{
		ModelAndView obj = new ModelAndView("error");
		obj.addObject("title","403- Access Denied");
		obj.addObject("errorTitle","Invalid User/Password");
		obj.addObject("errorDescription","You are not Authorized to view this page !");
		return obj;
	}
	
	@RequestMapping(value = "/listproduct", method = RequestMethod.GET)
	public ModelAndView listprod() {
		ModelAndView mv = new ModelAndView("listproduct");
		mv.addObject("title", "Product");
		mv.addObject("userClicklistProduct", true);
		mv.addObject("products", p.list());
		mv.addObject("supps", s.list());
		mv.addObject("cates", c.list());
		mv.addObject("product", new Product());
		return mv;
	}
	@RequestMapping(value = "/listproduct/{cid}", method = RequestMethod.GET)
	public ModelAndView getprodbycate(@PathVariable("cid") int cid) {
		ModelAndView mv = new ModelAndView("listproduct");
		mv.addObject("products", p.listbycate(cid));
		mv.addObject("cates", c.list());
		return mv;
	}
	
	@RequestMapping(value = "/listproductbypid/{pid}", method = RequestMethod.GET)
	public ModelAndView getprodbyid(@PathVariable("pid") int pid) {
		ModelAndView mv = new ModelAndView("dispproduct");
		mv.addObject("product", p.get(pid));
		mv.addObject("supps", s.list());
		mv.addObject("cates", c.list());
		mv.addObject("cates", c.list());
		mv.addObject("products", p.list());
		return mv;
	}
	
}
 