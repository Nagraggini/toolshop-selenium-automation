package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	private final By pageTitle = By.cssSelector(".topic-block-title h2");

	private final By registerBtn = By.cssSelector(".ico-register");
	private final By loginBtn = By.cssSelector(".ico-login");
	private final By wishlistBtn = By.cssSelector(".wishlist-label");
	private final By shoppingCartBtn = By.cssSelector(".cart-label");
	
	public HomePage(WebDriver driver) {
		super(driver);	
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.
		wait.until(ExpectedConditions.textToBe(pageTitle,"Welcome to our store"));
	}
	
	/**
	 * Megnyitja a weboldalt.
	 */
	public void open() {		
		driver.get("https://demo.nopcommerce.com/");		
	}
	
	public RegisterPage clickRegister() {
	    click(registerBtn);
	    return new RegisterPage(driver);
	}

	public LoginPage clickLogin() {
	    click(loginBtn);
	    return new LoginPage(driver);
	}
}
