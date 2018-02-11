package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {

	@Id
	private int supid;
	private String  supname;
	
	//@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="supplier")	
	//private Set<Product> products=new HashSet<Product>(0);
	
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
}
