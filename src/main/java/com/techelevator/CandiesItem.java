package com.techelevator;

import java.math.BigDecimal;

public class CandiesItem extends Items{

	public CandiesItem (String name, BigDecimal price) {
		super(name, price);

	}

	@Override
	public String makeSound() {
		return "Munch Munch, Yum!";
	}
	

}
