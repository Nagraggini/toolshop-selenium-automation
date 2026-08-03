package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersListPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='page-title']");

	// Itt látható a felhasználó teljes neve. Lenyíló lista.
	private final By navMenuBtn = By.cssSelector("[data-test='nav-menu']");
			
	private final By signOutBtn = By.cssSelector("[data-test='nav-sign-out']");
		
	// Email cím kereső mező.
	private final By userSearchQuery = By.cssSelector("[data-test='user-search-query']");

	// Keresés gomb
	private final By userSearchSubmit = By.cssSelector("[data-test='user-search-submit']");

	// Keresi azt a gombot, amelynek a data-test attribútuma ezzel az előtaggal
	// kezdődik.
	private final By deleteUserBtn = By.cssSelector("button[data-test^='user-delete-']");

	public UsersListPage(WebDriver driver) {
		super(driver);
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.
		wait.until(ExpectedConditions.textToBe(pageTitle, "Users"));
	}

	/**
	 * A teljes email címet adjuk meg, hogy csak egy találatot kapjunk vissza. Utána
	 * rá is kattintunk a keresés gombra.
	 */
	public UsersListPage clearAndTypeEmailAddressAndClickSearchBtn(String email) {
		clearAndType(userSearchQuery, email);
		click(userSearchSubmit);
		return this;
	}

	public UsersListPage clickDeleteUserBtn() {
		click(deleteUserBtn);
		return this;
	}

	public LoginPage clickSignOut() {
		click(navMenuBtn);
		click(signOutBtn);
		return new LoginPage(driver);
	}
}
