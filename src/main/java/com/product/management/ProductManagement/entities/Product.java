package com.product.management.ProductManagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_name")
	private String productname;
	
	@Column(name = "product_code")
	private String productcode;
	
	private String price;
	
	private String description;
	
	private long userid;

	public Product() {

    }
	
	public Product(String productname, String productcode, String price, String description,long userid) {
		super();
		this.productname = productname;
		this.productcode = productcode;
		this.price = price;
		this.description = description;
		this.userid=userid;
	}

	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
