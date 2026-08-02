package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CartPage;

class ModifyCartItemQuantityTest extends BaseTest {

	/**
	 * TC10 Adatmódosítás a mennyiségen keresztül.
	 */
	@Test
	void addProductChangeQuantityViaReadAndRemove() {
		String productName1="Combination Pliers";
		
		CartPage cartPage=homePage.clickSpecificItem(productName1).addToCart().clickCart();
		/*
		 * TODO: 
		 * assertEquals("1", cart.getQuantityTextForFirstRow(), "A kosárban 1 db terméknek kell lennie");
		 * cart.removeFirstRow();
		assertEquals(0, cart.getRowCount(), "A kosárnak üresnek kell lennie");

		products = new HomePage(driver).goToProducts();

		details = products.openFirstProductDetails();
		details.setQuantity(5).addToCart();
		cart = details.goToCartFromModal();

		assertEquals("5", cart.getQuantityTextForFirstRow(), "A kosárban 5 db terméknek kell lennie");
		 */
	}

}
