package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CartPage;
import utils.ConfigReader;

class ModifyCartItemQuantityTest extends BaseTest {

	/**
	 * TC10 Adatmódosítás a mennyiségen keresztül.
	 */
	@Test
	void addProductChangeQuantityViaReadAndRemove() {
		String productName1="Combination Pliers";
		
		CartPage cartPage=homePage.clickSignIn()
	            .fillEmail(ConfigReader.getAdminEmail())
	            .fillPassword(ConfigReader.getAdminPassword())
	            .clickLogin().clickHome().clickSpecificItem(productName1).addToCart()
	            .clickCart();
		
		assertEquals("1",cartPage.getQuantityInputByProductName(productName1)
				,"A kosárban 1 db terméknek kell lennie");
		cartPage.clickDeleteButtonByProductName(productName1);
		assertTrue(cartPage.emptyCartMessageVisible(), "A kosárnak üresnek kell lennie");
		
		
		/*
		 * TODO: 		 
		

		products = new HomePage(driver).goToProducts();

		details = products.openFirstProductDetails();
		details.setQuantity(5).addToCart();
		cart = details.goToCartFromModal();

		assertEquals("5", cart.getQuantityTextForFirstRow(), "A kosárban 5 db terméknek kell lennie");
		 */
	}

}
