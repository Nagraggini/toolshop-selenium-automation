package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='page-title']");

	private final By homeBtn = By.cssSelector("[data-test='nav-home']");

	// Itt látható a felhasználó teljes neve. Lenyíló lista.
	private final By navMenuBtn = By.cssSelector("[data-test='nav-menu']");

	//Ez csak az admin felületen érhető el.
	private final By usersListBtn = By.cssSelector("[data-test='nav-admin-users']");
	
	private final By signOutBtn = By.cssSelector("[data-test='nav-sign-out']");

	private final By welcomeMessage = By.xpath("//p[contains(text(),'profile')]");

	public AccountPage(WebDriver driver) {
		super(driver);
		// Megvárjuk, hogy a pageTitle szövege VAGY "My account"
		//, VAGY "Sales over the years" legyen (admin portál).
	    wait.until(ExpectedConditions.or(
	        ExpectedConditions.textToBe(pageTitle, "My account"),
	        ExpectedConditions.textToBe(pageTitle, "Sales over the years")
	    ));
	    waitUntilVisible(navMenuBtn);
	}

	/**
	 * Visszatérünk a főoldalra.
	 */
	public HomePage clickHome() {
		click(homeBtn);
		return new HomePage(driver);
	}

	// Here you can manage your profile, favorites and orders.
	public String getWelcomeMessage() {
		return getText(welcomeMessage);
	}

	// Itt látható a felhasználó teljes neve.
	public String getUserFullName() {
		return getText(navMenuBtn);
	}
	
	/**
	 * Ez csak az admin felületen érhető el.
	 */
	public UsersListPage clickUsersList() {
		click(navMenuBtn);
		click(usersListBtn);
		return new UsersListPage(driver);
	}
	
	public LoginPage clickSignOut() {
		click(navMenuBtn);
		click(signOutBtn);
		return new LoginPage(driver);
	}
	
	/**
	 * Megnézzük, hogy látható-e a felhasználó teljesneve.
	*/
	public boolean isUserMenuDisplayed() {
	    return isDisplayed(navMenuBtn);
	}

}
