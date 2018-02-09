package com.techelevator;

import java.math.BigDecimal;

public class DrinksItem extends Items{

	
	public DrinksItem (String name, BigDecimal price) {
		super(name, price);

	}

	@Override
	public String makeSound() {
		return "Glug Glug, Yum";
	}
	
	
	
}
