package com.techelevator;

import java.math.BigDecimal;

abstract class Items {

	private String name;
	private BigDecimal price;
	
	
	public Items (String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract String makeSound();
	
	public String consume() {
		return makeSound();
	}
	
	@Override
	public String toString() {
		return name +" , " + price ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

	
	
	
}
