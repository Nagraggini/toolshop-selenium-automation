package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import utils.ConfigReader;

// Selenium Page Object Model + Fluent Page Chaining
class RegistrationTest extends BaseTest {

	/**
	 * TC01 Sikeres regisztráció ellenőrzése.
	 */
	@Test
	@DisplayName("TC01 - Sikeres regisztráció és bejelentkezés ellenőrzése.")	
	void successfulRegistrationTest() {			
		
		// Az idei évből kivon 20-at, és YYYY-MM-DD formátumra alakítja (pl. 2006-01-01).
		// 18 és 75 év közöttinek kell lennie az új felhasználónak. 
		String dateOfBirth = LocalDate.now().minusYears(20)
		    .withMonth(1)
		    .withDayOfMonth(1)
		    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		 AccountPage accountPage = homePage.clickSignIn()
			        .clickRegister()
			        .fillFirstName(testData.getFirstName())
			        .fillLastName(testData.getLastName())
			        .fillDateOfBirth(dateOfBirth)
			        .fillHouseNumber("10")
			        .fillPostalCode("12345")
			        .selectCountry("Hungary")
			        .fillPhone("301234567")
			        .fillEmail(testData.getEmail())
			        .fillPassword(testData.getPassword())
			        .clickRegister()
			        .fillEmail(testData.getEmail())
			        .fillPassword(testData.getPassword()).clickLogin();
				 
		assertEquals("Here you can manage your profile, favorites and orders."
		,accountPage.getWelcomeMessage());
		
		 // Kijelentkezünk.
	    accountPage.clickSignOut();
	    
	    // Fiók törlése az admin fiók segítségével. 
	    // Ha épp más használja az admin fiókot, akkor a lenti sorokat ki lehet kommentezni ideiglenesen.      
	    // Az oldal pár perc múlva automatikusan törli az új felhasználókat. 
	    homePage.clickSignIn()
        .fillEmail(ConfigReader.getAdminEmail())
        .fillPassword(ConfigReader.getAdminPassword())
        .clickLogin().clickUsersList().clearAndTypeEmailAddressAndClickSearchBtn(testData.getEmail())
        .clickDeleteUserBtn().clickSignOut();
	}
	
	/**
	 * TC02 Sikertelen regisztráció ellenőrzése.
	 */
	@Test
	@DisplayName("TC02 - Sikertelen regisztráció kötelező keresztnév hiánya miatt.")
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
