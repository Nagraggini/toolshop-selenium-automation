package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='page-title']");
			
	// Itt látható a felhasználó teljes neve. Lenyíló lista.
	private final By navMenuBtn = By.cssSelector("[data-test='nav-menu']");	
	
	private final By signOutBtn = By.cssSelector("[data-test='nav-sign-out']");	
	
	private final By welcomeMessage = By.xpath("//p[contains(text(),'profile')]");
	
	public AccountPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "My account"));
	}
	
	// Here you can manage your profile, favorites and orders.
	public String getWelcomeMessage() {
		return getText(welcomeMessage);
	}
	
	// Itt látható a felhasználó teljes neve.
	public String getUserFullName() {
		return getText(navMenuBtn);
	}
	
	public LoginPage clickSignOut() {
		 click(navMenuBtn);
		 click(signOutBtn);
		return new LoginPage(driver);
	}			

}
