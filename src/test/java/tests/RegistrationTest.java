package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.TestData;
import pages.HomePage;
import pages.RegisterPage;

// Selenium Page Object Model + Fluent Page Chaining
class RegistrationTest extends BaseTest {

	/**
	 * TC01 Sikeres regisztráció ellenőrzése.
	 */
	@Test
	void successfulRegistrationTest() {			
		
		assertEquals("Here you can manage your profile, favorites and orders."
		,homePage.clickSignIn()
        .clickRegister()
        .fillFirstName(testData.getFirstName())
        .fillLastName(testData.getLastName())
        .fillDateOfBirth("1990-01-01")
        .fillHouseNumber("10")
        .fillPostalCode("12345")
        .selectCountry("Hungary")
        .fillPhone("301234567")
        .fillEmail(testData.getEmail())
        .fillPassword(testData.getPassword())
        .clickRegister()
        .fillEmail(testData.getEmail())
        .fillPassword(testData.getPassword()).clickLogin().getWelcomeMessage());
		
		// Pár perc múlva automatikusan törli az oldal az új felhasználót.
	}
	
	/**
	 * TC02 Sikertelen regisztráció ellenőrzése.
	 */
	@Test
	void unsuccessfulRegistrationTest() {			
		
		assertEquals("First name is required",homePage.clickSignIn()
        .clickRegister()
        .fillLastName(testData.getLastName())
        .fillDateOfBirth("1990-01-01")
        .fillHouseNumber("10")
        .fillPostalCode("12345")
        .selectCountry("Hungary")
        .fillPhone("301234567")
        .fillEmail(testData.getEmail())
        .fillPassword(testData.getPassword())
        .clickRegisterWithoutFluentPOM().getMissingFirstNameErrorMessage(null));	
	
	}
	

}
