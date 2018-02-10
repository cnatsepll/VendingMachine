package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class testVendingMachine {

	VendingMachine VM500;
	ChipsItem chips;

	@Before
	public void setUp() throws Exception {
		VM500 = new VendingMachine();
		VM500.addToBalance(new BigDecimal("10"));
	}

	@Test
	public void testGenerateInventory() {
		assertNotNull(VM500.getInventory());
	}

	@Test
	public void testGetInventory() {
		assertEquals(VM500.getInventory(), VM500.getInventory());

	}

	@Test
	public void testGetA1() {
		assertEquals("Potato Crisps", VM500.getInventory().get("A1").peek().getName());

	}

	@Test
	public void testGetA1Price() {
		assertEquals(new BigDecimal("3.05"), VM500.getInventory().get("A1").peek().getPrice());

	}

	@Test
	public void testVendingMachineBalance() {
		assertEquals(new BigDecimal("10.00"), VM500.getBalance());

	}

	public void testVendingMachinePurchase() {
		assertEquals("Your change is: 40 Quarter(s) 0 Dime(s) 0 Nickel(s) \n" + "Your new balance is $"
				+ new BigDecimal("0.00"), VM500.returnChange());
	}

	@Test
	public void testCosumeItems() throws OutOfStockException, InsufficientFundsException {
		List<Items> currentBasket = new ArrayList<>();
		PurchaseBasket yourCart = new PurchaseBasket();
		Items boughtItem = VM500.purchaseItem("A1");
		yourCart.addToBasket(boughtItem);
		assertEquals("Crunch Crunch, Yum!\n", yourCart.consumeBasket());

	}

	@Test
	public void testGetSound() {
		chips = new ChipsItem("Name", new BigDecimal("0"));
		assertEquals("Crunch Crunch, Yum!", chips.makeSound());
	}

	@Test
	public void testStackDrop() {
		VM500.getInventory().get("A1").pop();
		assertEquals(4, VM500.getInventory().get("A1").size());
	}

	@Test
	public void testGetInvalidItem() {
		assertNull(VM500.getInventory().get("A6").peek());
	}
}
