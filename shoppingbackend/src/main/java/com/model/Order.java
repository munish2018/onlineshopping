package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused") 
@Entity
@Component
public class Order {

	@Id
	@GeneratedValue
	private int orderid;
	
	@ManyToOne 
	@JoinColumn(name="orderemail")
	private User orderUserDetails;
	
	
	private Double totprice;
	private int totquantity;
	private Double total;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public User getOrderUserDetails() {
		return orderUserDetails;
	}
	public void setOrderUserDetails(User orderUserDetails) {
		this.orderUserDetails = orderUserDetails;
	}
	public Double getTotprice() {
		return totprice;
	}
	public void setTotprice(Double totprice) {
		this.totprice = totprice;
	}
	public int getTotquantity() {
		return totquantity;
	}
	public void setTotquantity(int totquantity) {
		this.totquantity = totquantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
