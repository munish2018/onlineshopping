package com.controller;

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

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.dao.SupplierDAO;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

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
	@RequestMapping(value="/productsave", method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest req,@RequestParam("file") MultipartFile file)
	{	
		Product product=new Product();
		product.setPname(req.getParameter("pname"));
		product.setPdescription(req.getParameter("pdescription"));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setUnitPrice(Double.valueOf(req.getParameter("unitPrice")));
		product.setCid(Integer.parseInt(req.getParameter("cid")));
		product.setSid(Integer.parseInt(req.getParameter("sid")));
		
		
		String imgpath=req.getSession().getServletContext().getRealPath("/resources/images/");
		String file_info=imgpath+file.getOriginalFilename()+".jpg";
		if(!file.isEmpty()){
			File f=new File(file_info);
			try{
			byte buff[]=file.getBytes();
			BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
			bs.write(buff);
			bs.close();
			product.setImageurl(file.getOriginalFilename());
			p.add(product);
			}
			catch(Exception e){
				System.out.println("Exception");
			}
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admin");
		return mv;
	}
	@RequestMapping(value="/productupdate", method = RequestMethod.POST)
	public String editprod(@ModelAttribute("product") Product product, HttpServletRequest request,@RequestParam("file") MultipartFile file) {
		System.out.println("  Product  update ");
		System.out.println("Product id :" + product.getPid());
		System.out.println("Product name :" + product.getPname());
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setUnitPrice(Double.valueOf(request.getParameter("unitPrice")));
		product.setCid(Integer.parseInt(request.getParameter("cid")));
		product.setPid(Integer.parseInt(request.getParameter("pid")));
		String imgpath=request.getSession().getServletContext().getRealPath("/resources/images/");
		String file_info=imgpath+file.getOriginalFilename()+".jpg";
		if(!file.isEmpty()){
			File f=new File(file_info);
			try{
			byte buff[]=file.getBytes();
			BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
			bs.write(buff);
			bs.close();
			product.setImageurl(file.getOriginalFilename());
			p.update(product);
			}
			catch(Exception e){
				System.out.println("Exception");
			}
		}
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView dispprod() {
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct", true);
		mv.addObject("products", p.list());
		mv.addObject("supps", s.list());
		mv.addObject("cates", c.list());
		mv.addObject("product", new Product());
		return mv;
	}
	@RequestMapping(value = "/product/{pid}", method = RequestMethod.GET)
	public ModelAndView getprodbyid(@PathVariable("pid") int pid) {
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", p.get(pid));
		mv.addObject("supps", s.list());
		mv.addObject("cates", c.list());
		mv.addObject("products", p.list());
		return mv;
	}
	
	@RequestMapping(value = "/deleteproduct/{pid}")
	public String deleteproduct(@PathVariable("pid") int pid) {
		System.out.println(" product Delete ");
		System.out.println("pid " + pid);
		p.delete(pid);
		return "redirect:/admin/product";
	}
}
