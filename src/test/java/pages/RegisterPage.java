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
	        driver.findElement(firstNameInput).sendKeys(firstName);
	        return this;
	    }


	    public RegisterPage fillLastName(String lastName) {
	        driver.findElement(lastNameInput).sendKeys(lastName);
	        return this;
	    }


	    public RegisterPage fillDateOfBirth(String dateOfBirth) {
	        driver.findElement(dateOfBirthInput).sendKeys(dateOfBirth);
	        return this;
	    }


	    public RegisterPage fillStreet(String street) {
	        driver.findElement(streetInput).sendKeys(street);
	        return this;
	    }
	    
	    public RegisterPage fillHouseNumber(String number) {
	        driver.findElement(houseNumberInput).sendKeys(number);
	        return this;
	    }


	    public RegisterPage fillPostalCode(String postalCode) {
	        driver.findElement(postalCodeInput).sendKeys(postalCode);
	        return this;
	    }


	    public RegisterPage fillCity(String city) {
	        driver.findElement(cityInput).sendKeys(city);
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
	        driver.findElement(phoneInput).sendKeys(phone);
	        return this;
	    }


	    public RegisterPage fillEmail(String email) {
	        driver.findElement(emailInput).sendKeys(email);
	        return this;
	    }


	    public RegisterPage fillPassword(String password) {
	        driver.findElement(passwordInput).sendKeys(password);
	        return this;
	    }


	    public LoginPage clickRegister() {
	        driver.findElement(registerButton).click();
	        return new LoginPage(driver);
	    }
	    
	    public RegisterPage clickRegisterWithoutFluentPOM() {
	        driver.findElement(registerButton).click();
	        return new RegisterPage(driver);
	    }
	    
	   /**
	    *  Megjelenő üzenet: "First name is required"
	    */
	    public String getMissingFirstNameErrorMessage(String errorMessage) {
	    	return getText(firstNameErrorMessage);	        
	    }
}
