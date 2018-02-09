package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String PURCHASE_DISPLAY_FEED = "Feed Money";
	private static final String PURCHASE_DISPLAY_SELECT = "Select Product";
	private static final String PURCHASE_DISPLAY_FINAL = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_DISPLAY_FEED, PURCHASE_DISPLAY_SELECT,
			PURCHASE_DISPLAY_FINAL };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		InventoryReader newInventory = new InventoryReader();
		VendingMachine VM500;
		PurchaseBasket yourCart = new PurchaseBasket();

		VM500 = new VendingMachine();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// InventoryReader.inventoryImport();
				int counter = 0;
				for (String slotID : VM500.getInventory().keySet()) {

					System.out.println(VM500.getInventory().keySet().toArray()[counter]);
					System.out.println(VM500.getInventory().get(slotID).toArray()[0]);
					System.out.println("Amount Left: " + VM500.getInventory().get(slotID).size());
					System.out.println();
					counter++;
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS,
							"\nCurrent Money Provided: $" + VM500.getBalance());
					// System.out.println("What would you like to purchase? ");
					// Scanner userInput = new Scanner(System.in);
					// String userChoice = userInput.nextLine();
					// VM500.getInventory().get(userChoice).pop();
					
					if (choice.equals(PURCHASE_DISPLAY_FEED)) {
						BigDecimal amount = menu.getAmountFromUserInput();
						while(amount != null) {
							VM500.addToBalance(amount);
							System.out.println("Your current balance is: $" + VM500.getBalance());
							
							amount = menu.getAmountFromUserInput();
							
						}
						
						
						// menu.getAmountFromUserInput();
						// System.out.println("your balance is: $" + VM500.getBalance());

					}

					if (choice.equals(PURCHASE_DISPLAY_SELECT)) {
						System.out.println("What would you like to buy?");
						Scanner userInput = new Scanner(System.in);
						String purchaseKey = userInput.nextLine();
						Items boughtItem = null;
						try {
							boughtItem = VM500.purchaseItem(purchaseKey);
							yourCart.addToBasket(boughtItem);
							System.out.println(boughtItem);
						} catch (OutOfStockException e) {
							System.out.println(e.getMessage());
							choice.equals(PURCHASE_DISPLAY_SELECT);
						} catch (InsufficientFundsException e) {
							System.out.println(e.getMessage());
							choice.equals(PURCHASE_DISPLAY_SELECT);
						}
					}

					if (choice.equals(PURCHASE_DISPLAY_FINAL)) {
						System.out.println(VM500.returnChange());
						System.out.println(yourCart.consumeBasket());
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
