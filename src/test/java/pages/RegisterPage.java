package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

	private final By pageTitle = By.cssSelector(".page-title h1");

	// Gender
	private final By genderMale = By.id("gender-male");
	private final By genderFemale = By.id("gender-female");

	// Személyes adatok
	private final By firstName = By.id("FirstName");
	private final By lastName = By.id("LastName");
	private final By email = By.id("Email");

	// Cég adatok
	private final By company = By.id("Company");

	// Újdonságok
	private final By newsletter = By.id("Newsletter");

	// Jelszavak
	private final By password = By.id("Password");
	private final By confirmPassword = By.id("ConfirmPassword");

	// Hibaüzenet, ha nincs kitöltve a jelszó mező.
	private final By passwordErrorMessage=By.id("ConfirmPassword-error");
	
	// Regisztrációs gomb
	private final By registerButton = By.id("register-button");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Register"));
	}

	public RegisterPage selectMaleGender() {
		click(genderMale);
		return this;
	}

	public RegisterPage selectFemaleGender() {
		click(genderFemale);
		return this;
	}
	
	public RegisterPage fillFirstName(String value) {
		type(firstName, value);
		return this;
	}

	public RegisterPage fillLastName(String value) {
		type(lastName, value);
		return this;
	}

	public RegisterPage fillEmail(String value) {
		type(email, value);
		return this;
	}

	// Mindkét jelszó mezőt kitölti.
	public RegisterPage fillPassword(String value) {
		type(password, value);
		type(confirmPassword, value);
		return this;
	}
	
	// Password is required.
	public String getMissingPasswordErrorMessage() {
			return getText(passwordErrorMessage);
	}
		
	public RegisterResultPage clickRegistration() {
		click(registerButton);
		return new RegisterResultPage(driver);		
	}
}
