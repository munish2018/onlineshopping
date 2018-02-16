package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CartDAO;
import com.dao.OrdersDAO;
import com.dao.UserDAO;
import com.model.Cart;
import com.model.Orders;
import com.model.User;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	OrdersDAO ordersdao;
	
	
	@RequestMapping("/cart")
	public ModelAndView goToCart(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("cart");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		mv.addObject("cartlist",cartdao.findcartbyid(useremail));
		return mv;
	}
	
	@RequestMapping(value = "/cart/addtocart", method=RequestMethod.POST)
	public ModelAndView addcart(HttpServletRequest req) 
		{
		ModelAndView mv = new ModelAndView("redirect:/cart");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		try
		{
			int pid=Integer.parseInt(req.getParameter("pid"));
			String imagename=req.getParameter("imagename");
			String pname=req.getParameter("pname");
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			double unitprice=Double.valueOf(req.getParameter("unitPrice"));
			Cart cartexist=cartdao.getcartbyid(pid, useremail);
			if(cartexist==null)
			{
				Cart cart=new Cart();
				cart.setCartImage(imagename);
				cart.setCartPrice(unitprice);
				cart.setCartProductName(pname);
				cart.setCartProductId(pid);
				cart.setCartQuantity(quantity);
				User u=new User();
				u.setEmail(useremail);
				cart.setCartUserDetails(u);
				cartdao.insert(cart);
			}
			else
			{
				cartexist.setCartImage(imagename);
				cartexist.setCartPrice(unitprice);
				cartexist.setCartProductName(pname);
				cartexist.setCartProductId(pid);
				int qty=cartexist.getCartQuantity();
				qty=qty+quantity;
				cartexist.setCartQuantity(qty);
				User u=new User();
				u.setEmail(useremail);
				cartexist.setCartUserDetails(u);
				cartdao.update(cartexist);
			}	
				return mv;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping("/cart/updateaddr")
	public ModelAndView changeaddr(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("shipping");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		User user=userdao.getByEmail(useremail);
		user.setBillingaddress(req.getParameter("billingaddress"));
		user.setShippingaddress(req.getParameter("shippingaddress"));
		userdao.update(user);
		mv.addObject("useraddr",user);
		return mv;
	}
	
		
	@RequestMapping("/cart/deletecart/{cartId}")
	public ModelAndView deleteCart(@PathVariable int cartId) {
		ModelAndView m = new ModelAndView("redirect:/cart");
		cartdao.deletecart(cartId);
		return m;
	}
	
	@RequestMapping("/cart/checkout")
	public ModelAndView checkoutpro(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("shipping");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		mv.addObject("useraddr",userdao.getByEmail(useremail));
		return mv;
	}
	
	@RequestMapping(value="/cart/orderprocess",method=RequestMethod.POST)
	public ModelAndView proord(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("redirect:/cart/inv");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		String paymode=req.getParameter("paymode");
		System.out.println(" Payment Mode :"+paymode);
		try
		{
		List<Cart> list=cartdao.findcartbyid(useremail);
		double totprice=0;
		int totqty=0;
		double totbill=0;
		for(Cart c:list)
		{
		totprice+=c.getCartPrice();
		totqty+=c.getCartQuantity();
		System.out.println("price :"+totprice);
		System.out.println("qty :"+totqty);
		}
		totbill=totprice*totqty;
		System.out.println(" Email 111:"+useremail);
		Orders ords=null;
		ords=ordersdao.findorderbyid(useremail);
		if (ords==null)
		{
			System.out.println(" Email 222 :");
			Orders ord=new Orders();
			ord.setPayment(paymode);
			ord.setTotal(totbill);
			ord.setOrderemail(useremail);
			ordersdao.insert(ord);
			System.out.println(" Email 225 :"+useremail);
		}
		else
		{
			System.out.println(" Email333 :"+useremail);
			ords.setPayment(paymode);
			ords.setTotal(totbill);
			ords.setOrderemail(useremail);
			ordersdao.update(ords);
			System.out.println(" Email335 :"+useremail);
		}
		System.out.println(" Email :6666");
		return mv;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return mv;
		}
		
	}
	
	@RequestMapping("/cart/inv")
	public ModelAndView gotoship(HttpServletRequest req) 
	{
		ModelAndView mv = new ModelAndView("invoice");
		Principal principal=req.getUserPrincipal();
		String useremail=principal.getName();
		mv.addObject("userdet",userdao.getByEmail(useremail));
		mv.addObject("orddet",ordersdao.findorderbyid(useremail));
		mv.addObject("cartlist",cartdao.findcartbyid(useremail));
		return mv;
	}
	
	@RequestMapping("/cart/thanku")
	public ModelAndView thanks(HttpServletRequest req) 
	{
		ModelAndView mv = new ModelAndView("thanks");
		return mv;
	}
	
	
	
	
}
