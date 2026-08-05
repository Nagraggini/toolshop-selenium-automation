package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

	private final By pageTitle = By.xpath("//h3[normalize-space()='Customer registration']");

	// Adat mezők
	private final By firstNameInput = By.cssSelector("[data-test='first-name']");
	private final By lastNameInput = By.cssSelector("[data-test='last-name']");
	private final By dateOfBirthInput = By.cssSelector("[data-test='dob']");
	private final By streetInput = By.cssSelector("[data-test='street']");
	private final By houseNumberInput = By.cssSelector("[data-test='house_number']");
	private final By postalCodeInput = By.cssSelector("[data-test='postal_code']");
	private final By cityInput = By.cssSelector("[data-test='city']");
	private final By stateInput = By.cssSelector("[data-test='state']");
	private final By countrySelect = By.cssSelector("[data-test='country']");
	private final By phoneInput = By.cssSelector("[data-test='phone']");
	private final By emailInput = By.cssSelector("[data-test='email']");
	private final By passwordInput = By.cssSelector("[data-test='password']");

	// Regisztrációs gomb
	private final By registerButton = By.cssSelector("[data-test='register-submit']");

	// Hiányzó keresztnév hibaüzenet
	private final By firstNameErrorMessage = By.cssSelector("[data-test='first-name-error']");

	public RegisterPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Customer registration"));
	}

	public RegisterPage fillFirstName(String firstName) {
		clearAndType(firstNameInput, firstName);
		return this;
	}

	public RegisterPage fillLastName(String lastName) {
		clearAndType(lastNameInput, lastName);
		return this;
	}

	public RegisterPage fillDateOfBirth(String dateOfBirth) {
		clearAndType(dateOfBirthInput, dateOfBirth);
		return this;
	}

	public RegisterPage fillStreet(String street) {
		clearAndType(streetInput, street);
		return this;
	}

	public RegisterPage fillHouseNumber(String number) {
		clearAndType(houseNumberInput, number);
		return this;
	}

	public RegisterPage fillPostalCode(String postalCode) {
		clearAndType(postalCodeInput, postalCode);
		return this;
	}

	public RegisterPage fillCity(String city) {
		clearAndType(cityInput, city);
		return this;
	}

	public RegisterPage fillState(String state) {
		driver.findElement(stateInput).sendKeys(state);
		return this;
	}

	public RegisterPage selectCountry(String country) {
		Select select = new Select(driver.findElement(countrySelect));
		select.selectByVisibleText(country);
		return this;
	}

	public RegisterPage fillPhone(String phone) {
		clearAndType(phoneInput, phone);
		return this;
	}

	public RegisterPage fillEmail(String email) {
		clearAndType(emailInput, email);
		return this;
	}

	public RegisterPage fillPassword(String password) {
		clearAndType(passwordInput, password);
		return this;
	}

	public LoginPage clickRegister() {
		click(registerButton);
		return new LoginPage(driver);
	}

	public RegisterPage clickRegisterWithoutFluentPOM() {
		driver.findElement(registerButton).click();
		return new RegisterPage(driver);
	}

	/**
	 * Megjelenő üzenet: "First name is required"
	 */
	public String getMissingFirstNameErrorMessage(String errorMessage) {
		return getText(firstNameErrorMessage);
	}
}
