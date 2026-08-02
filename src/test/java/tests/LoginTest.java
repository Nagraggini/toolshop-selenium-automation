package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.ConfigReader;

class LoginTest extends BaseTest {

	/**
	 * TC03 Bejelentkezés.
	 */
	@Test
	@DisplayName("TC03 - Sikeres bejelentkezés ellenőrzése.")
	void loginTest() {  	    
	    assertEquals("Bob Smith",homePage.clickSignIn()
	            .fillEmail(ConfigReader.getBobEmail())
	            .fillPassword(ConfigReader.getBobPassword())
	            .clickLogin().getUserFullName());
	}

}
