package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private final By pageTitle = By.xpath("//h3[normalize-space()='Login']");

	private final By emailInput = By.cssSelector("[data-test='email']");
	private final By passwordInput = By.cssSelector("[data-test='password']");
	private final By loginBtn = By.cssSelector("[data-test='login-submit']");

	private final By registerBtn = By.cssSelector("[data-test='register-link']");

	public LoginPage(WebDriver driver) {
		super(driver);
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.
		wait.until(ExpectedConditions.textToBe(pageTitle, "Login"));
	}

	public LoginPage fillEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
		return this;
	}

	public LoginPage fillPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
		return this;
	}

	public AccountPage clickLogin() {
		click(loginBtn);
		return new AccountPage(driver);
	}
	
	public RegisterPage clickRegister() {
		click(registerBtn);
		return new RegisterPage(driver);
	}
}
