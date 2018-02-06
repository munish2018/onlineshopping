package com.niitmrt.onlineshopping.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niitmrt.shoppingbackend.dao.CategoryDAO;
import com.niitmrt.shoppingbackend.dao.ProductDAO;
import com.niitmrt.shoppingbackend.dao.SupplierDAO;
import com.niitmrt.shoppingbackend.model.Category;
import com.niitmrt.shoppingbackend.model.Product;
import com.niitmrt.shoppingbackend.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	SupplierDAO s;

	@Autowired
	CategoryDAO c;

	@Autowired
	ProductDAO p;

	// supplier methods

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public ModelAndView dispsupp() {
		ModelAndView mv = new ModelAndView("supplier");
		mv.addObject("title", "Supplier");
		mv.addObject("userClickSupplier", true);
		mv.addObject("supps", s.list());
		mv.addObject("supp", new Supplier());
		return mv;
	}

	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET)
	public ModelAndView getsuppbyid(@PathVariable("id") int sid) {
		ModelAndView mv = new ModelAndView("supplier");
		mv.addObject("supp", s.get(sid));
		mv.addObject("supps", s.list());
		return mv;
	}

	@RequestMapping(value = "/deletesupp/{sid}")
	public String deletesuppbyid(@PathVariable("sid") int sid) {
		System.out.println("  Supplier Delete ");
		System.out.println("Sid " + sid);
		s.delete(sid);
		return "redirect:/admin/supplier";
	}

	@PostMapping("/suppsave")
	public String savesuppdet(@ModelAttribute("supp") Supplier supp, HttpServletRequest request) {
		System.out.println("  Supplier save ");
		System.out.println("supp id :" + supp.getSupid());
		System.out.println("supp name :" + supp.getSupname());
		s.add(supp);
		return "redirect:/admin";
	}

	@PostMapping("/suppupdate")
	public String editsuppdet(@ModelAttribute("supp") Supplier supp, HttpServletRequest request) {
		System.out.println("  Supplier update ");
		System.out.println("supp id :" + supp.getSupid());
		System.out.println("supp name :" + supp.getSupname());
		s.update(supp);
		return "redirect:/admin/supplier";
	}

	// category methods

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView dispcate() {
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("title", "Category");
		mv.addObject("userClickCategory", true);
		mv.addObject("cates", c.list());
		mv.addObject("cate", new Category());
		return mv;
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView getcate(@PathVariable("id") int cid) {
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("cate", c.get(cid));
		mv.addObject("cates", c.list());
		return mv;
	}

	@RequestMapping(value = "/deletecate/{cid}")
	public String deletecate(@PathVariable("cid") int cid) {
		System.out.println("  Category Delete ");
		System.out.println("cid " + cid);
		c.delete(cid);
		return "redirect:/admin/category";
	}

	@PostMapping("/catesave")
	public String savecate(@ModelAttribute("cate") Category cate, HttpServletRequest request) {
		System.out.println("  Category save ");
		System.out.println("supp id :" + cate.getCid());
		System.out.println("supp name :" + cate.getCname());
		c.add(cate);
		return "redirect:/admin";
	}

	@PostMapping("/cateupdate")
	public String editcate(@ModelAttribute("cate") Category cate, HttpServletRequest request) {
		System.out.println("  Category update ");
		System.out.println("supp id :" + cate.getCid());
		System.out.println("supp name :" + cate.getCname());
		c.update(cate);
		return "redirect:/admin/category";
	}

	// Product
	// admin->product option selected
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView dispsuppprod() {
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct", true);
		mv.addObject("supps", s.list());
		mv.addObject("cates", c.list());
		return mv;
	}

	@RequestMapping(value="/productsave",method=RequestMethod.POST)
	public String saveproduct( HttpServletRequest request,@RequestParam("file") MultipartFile file)
	{	
		Product product=new Product();
		product.setPname(request.getParameter("pname"));
		product.setPdescription(request.getParameter("pdescription"));
		product.setUnitPrice(Double.valueOf(request.getParameter("unitPrice")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		product.setImageurl(filename);
		p.add(product);
		System.out.println("  Product save ");
		System.out.println("product name :"+product.getPname());
		System.out.println("product description :"+product.getPdescription());
		System.out.println("product filename :"+filename);
			try
			{
				byte[] imagebyte=file.getBytes();
				BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/images/"+filename));
				fos.write(imagebyte);
				fos.close();
			}
			catch(Exception ex)
			{
				System.out.println("  error "+ex);
			}
			return "redirect:/admin";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView dispprod() {
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct", true);
		mv.addObject("products", p.list());
		mv.addObject("product", new Product());
		return mv;
	}
	@RequestMapping(value = "/product/{pid}", method = RequestMethod.GET)
	public ModelAndView getprodbyid(@PathVariable("pid") int pid) {
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", p.get(pid));
		mv.addObject("products", p.list());
		return mv;
	}
	@PostMapping("/productupdate")
	public String editprod(@ModelAttribute("product") Product product, HttpServletRequest request) {
		System.out.println("  Product  update ");
		System.out.println("Product id :" + product.getPid());
		System.out.println("Product name :" + product.getPname());
		p.update(product);
		return "redirect:/admin/product";
	}
	@RequestMapping(value="/deleteproduct",method = RequestMethod.GET)
	public String delprod(@ModelAttribute("product") Product product, HttpServletRequest request) {
		System.out.println("  Product  update ");
		System.out.println("Product id :" + product.getPid());
		System.out.println("Product name :" + product.getPname());
		p.delete(product);
		return "redirect:/admin/product";
	}
	

}
