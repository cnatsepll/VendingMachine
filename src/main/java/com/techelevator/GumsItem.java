package com.techelevator;

import java.math.BigDecimal;

public class GumsItem extends Items{

	
	public GumsItem (String name, BigDecimal price) {
		super(name, price);

	}

	@Override
	public String makeSound() {
		return "Chew Chew, Yum!";
	}
	
	
	
}
