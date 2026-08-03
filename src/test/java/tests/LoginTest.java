package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import utils.ConfigReader;

class LoginTest extends BaseTest {

	/**
	 * TC03 Bejelentkezés.
	 */
	@Test
	@DisplayName("TC03 - Sikeres bejelentkezés ellenőrzése.")
	void loginTest() {  
		// Bejelentkezünk.
	    AccountPage accountPage = homePage.clickSignIn()
	            .fillEmail(ConfigReader.getBobEmail())
	            .fillPassword(ConfigReader.getBobPassword())
	            .clickLogin();
	    
	    // Ellenőrizzük, hogy a helyes név jelenik-e meg.
	    assertEquals("Bob Smith", accountPage.getUserFullName(), "A bejelentkezett felhasználó neve nem megfelelő");
	    
	    // Kijelentkezünk.
	    accountPage.clickSignOut();
	    }

}
