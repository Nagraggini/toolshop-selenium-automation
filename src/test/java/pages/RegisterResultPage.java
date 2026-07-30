package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterResultPage extends BasePage {

	private final By pageTitle = By.cssSelector(".page-title h1");
	private final By result = By.cssSelector(".result");
	private final By continueBtn = By.cssSelector(".button-1.register-continue-button");
	
	public RegisterResultPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Register"));
	}
	
	// Your registration completed
	public String getResult() {
		return getText(result);
	}
	
	// Ön nem robot igazolás van amikor megjelenik. 
	
	// Home-ra térünk vissza
	public HomePage clickContinue() {
		click(continueBtn);
		return new HomePage(driver);
	}

}
