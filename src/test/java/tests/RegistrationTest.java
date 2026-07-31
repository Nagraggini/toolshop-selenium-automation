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
	 * Sikeres regisztráció ellenőrzése.
	 */
	@Test
	void successfulRegistrationTest() {		
		/*assertEquals("Your registration completed",homePage.clickRegister()
				.selectMaleGender()
				.fillFirstName(TestData.generateFirstName())
				.fillLastName(TestData.generateLastName())
				.fillEmail(TestData.generateEmail())
				.fillPassword(TestData.generatePassword()).clickRegistration().getResult());*/
		
		assertEquals("Here you can manage your profile, favorites and orders.",homePage.clickSignIn()
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
		
		// Pár perc múlva automatikusan törli az oldal a felhasználót.
	}
	

}
