package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.TestData;
import pages.HomePage;
import pages.RegisterPage;

// Selenium Page Object + Fluent Page Chaining
class RegistrationTest extends BaseTest {

	/**
	 * Sikeres regisztráció ellenőrzése.
	 */
	@Test
	void successfulRegistrationTest() {		
		assertEquals("Your registration completed",homePage.clickRegister()
				.selectMaleGender()
				.fillFirstName(TestData.generateFirstName())
				.fillLastName(TestData.generateLastName())
				.fillEmail(TestData.generateEmail())
				.fillPassword(TestData.generatePassword()).clickRegistration().getResult());
	}
	
	/**
	 * Sikerestelen regisztráció ellenőrzése.
	 */
	@Disabled
	@Test
	void unsuccessfulRegistrationTest() {		

	    RegisterPage registerPage = homePage.clickRegister();

	    registerPage
			.selectMaleGender()
			.fillFirstName(TestData.generateFirstName())
			.fillLastName(TestData.generateLastName())
	        .fillEmail(TestData.generateEmail())
	        .clickRegistration();

	    assertEquals(
	        "Password is required.",
	        registerPage.getMissingPasswordErrorMessage()
	    );
	}

}
