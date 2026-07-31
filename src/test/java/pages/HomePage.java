package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	private final By pageLogo = By.cssSelector("a.navbar-brand");
	
	private final By sigInBtn = By.cssSelector("[data-test='nav-sign-in']");	
	
	public HomePage(WebDriver driver) {
		super(driver);			
	}
	
	/**
	 * Megnyitja a weboldalt.
	 */
	public void open() {		
		driver.get("https://practicesoftwaretesting.com/");	
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageLogo));
	}
	
	public LoginPage clickSignIn() {	
	    click(sigInBtn);
	    return new LoginPage(driver);
	}	
	
}
