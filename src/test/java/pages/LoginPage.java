package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

	private final By pageTitle = By.cssSelector(".page-title h1");
	
	public LoginPage(WebDriver driver) {
		super(driver);	
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.
		wait.until(ExpectedConditions.textToBe(pageTitle,"Welcome, Please Sign In!"));
	}
}
