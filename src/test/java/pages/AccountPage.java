package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='page-title']");
	private final By welcomeMessage = By.xpath("//p[contains(text(),'profile')]");
	
	public AccountPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "My account"));
	}
	
	// Here you can manage your profile, favorites and orders.
	public String getWelcomeMessage() {
		return getText(welcomeMessage);
	}
			

}
