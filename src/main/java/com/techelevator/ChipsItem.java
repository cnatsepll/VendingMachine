package com.techelevator;

import java.math.BigDecimal;

public class ChipsItem extends Items {
	
	public ChipsItem (String name, BigDecimal price) {
		super(name, price);

	}

	@Override
	public String makeSound() {
		return "Crunch Crunch, Yum!";
	}
	

}
