package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class PurchaseBasket {
	private List<Items> currentBasket = new ArrayList<>();

	public void addToBasket(Items purchasedItem) {
		currentBasket.add(purchasedItem);
	}

	public String consumeBasket() {
//		while (!currentBasket.isEmpty()) {
//			System.out.println(currentBasket.remove(o).consume());
//		}
		String consumeSounds = "";
		if(!currentBasket.isEmpty()) {
		for(Items element : currentBasket) {
			consumeSounds = consumeSounds.concat(element.consume()+ "\n");
				
			}
			
		}
		return consumeSounds;
	}

}
