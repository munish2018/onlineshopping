package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused") 
@Entity
@Component
public class Orders
{

	@Id
	@GeneratedValue
	private int orderid;
	
	private String orderemail;
			
	private String payment;
	private Double total;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getOrderemail() {
		return orderemail;
	}
	public void setOrderemail(String orderemail) {
		this.orderemail = orderemail;
	}
	
}
