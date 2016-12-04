package com.eforcers.esfs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private int amountSold;
	private int minStock;
	private String name;
	private int stock;
	private ProductType type;
	private int unitPrice;


	public int getTotalSales(){
		return amountSold * unitPrice;
	}

	public void saleProduct(int amount) throws Exception{
		if(this.stock - amount > 0){
			this.stock -= amount;
			this.amountSold += amount;
		}else{
			throw new Exception("out of stock");
		}
		
	}
	
	
	/*
	 * setters and getters methods
	 */
	
		
	public Integer getId() {
		return id;
	}

	public int getAmountSold() {
		return amountSold;
	}

	public void setAmountSold(int amountSold) {
		this.amountSold = amountSold;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
