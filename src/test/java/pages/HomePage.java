package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	// A kategória menü lenyitása.
	private final By homeBtn = By.cssSelector("[data-test='nav-home']");
	private final By categoriesDropdown = By.cssSelector("[data-test='nav-categories']");
	private final By contactBtn = By.cssSelector("[data-test='nav-contact']");
	private final By signInBtn = By.cssSelector("[data-test='nav-sign-in']");

	// Itt látható a felhasználó teljes neve. Lenyíló lista.
	private final By navMenuBtn = By.cssSelector("[data-test='nav-menu']");

	private final By signOutBtn = By.cssSelector("[data-test='nav-sign-out']");

	private final By privacyPolicyLink = By.cssSelector("[routerlink='privacy']");

	// Termék kártyák.
	private final By productCardsLocator = By.cssSelector("a.card[data-test^='product-']");
	private final By productNames = By.cssSelector("[data-test='product-name']");
	private final By productPrices = By.cssSelector("[data-test='product-price']");

	private final By handToolsCategory = By.cssSelector("a[data-test='nav-hand-tools']");
	private final By handPowerToolsCategory = By.cssSelector("a[data-test='nav-power-tools']");
	private final By handOtherCategory = By.cssSelector("a[data-test='nav-other']");
	private final By specialToolsCategory = By.cssSelector("a[data-test='nav-special-tools']");

	private final By noProductsMessage = By.cssSelector("[data-test='category-empty']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Megnyitja a weboldalt és validálja is.
	 */
	public HomePage open() {
		//driver.get("https://practicesoftwaretesting.com/");
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.

		System.out.println("HomePage open() metódus: ");
		System.out.println("Aktuális URL: " + driver.getCurrentUrl());
		System.out.println("Oldal címe: " + driver.getTitle());
		System.out.println("HTML hossza: " + driver.getPageSource().length());
		System.out.println("A nav-home elem megjelent-e: " 
				+ (driver.findElements(homeBtn).size()>0));

		waitUntilVisible(homeBtn);
		return this;
	}

	public LoginPage clickSignIn() {
		click(signInBtn);
		return new LoginPage(driver);
	}

	public PrivacyPage clickPrivacyPolicyLink() {
		click(privacyPolicyLink);
		return new PrivacyPage(driver);
	}

	public List<String> getAllProductNames() {
		// Kategóriaváltáskor az Angular újrarendereli a kártyákat, ezért stale elem
		// esetén a wait következő próbálkozása frissen keresi meg őket.
		return wait.until(driver -> {
			try {
				List<WebElement> productNameElements = driver.findElements(productNames);
				if (productNameElements.isEmpty()) {
					return null;
				}

				List<String> names = new ArrayList<>();
				for (WebElement itemName : productNameElements) {
					names.add(itemName.getText().trim());
				}
				return names;
			} catch (StaleElementReferenceException e) {
				return null;
			}
		});
	}

	public HomePage clickHandToolsCategory() {
		click(categoriesDropdown);
		click(handToolsCategory);
		return this;
	}

	public HomePage clickHandPowerToolsCategory() {
		click(categoriesDropdown);
		click(handPowerToolsCategory);
		return this;
	}

	public HomePage clickHandOtherCategory() {
		click(categoriesDropdown);
		click(handOtherCategory);
		return this;
	}

	public HomePage clickSpecialToolsCategory() {
		click(categoriesDropdown);
		click(specialToolsCategory);
		return this;
	}

	public String getNoProductsMessage() {
		return getText(noProductsMessage);
	}

	public ContactPage clickContact() {
		click(contactBtn);
		return new ContactPage(driver);
	}

	/**
	 * pl.: Combination Pliers
	 */
	public ProductPage clickSpecificItem(String productName) {
		By specProduct = By.xpath("//h5[@data-test='product-name' and normalize-space()='" + productName + "']");
		click(specProduct);
		return new ProductPage(driver);

	}

	public HomePage clickSignOut() {
		click(navMenuBtn);
		click(signOutBtn);
		return this;
	}

	/**
	 * Visszaadja a főoldalon lévő termékek nevét és árát listák listájaként.
	 */
	public List<List<String>> getAllProductNamesAndPrices() {
		// Megvárjuk, hogy megjelenjenek a termékkártyák.
		waitForAllElementsPresent(productCardsLocator);

		List<WebElement> productElements = findAll(productCardsLocator);
		List<List<String>> productData = new ArrayList<>();

		for (WebElement product : productElements) {
			// Először a listán belül megkeressük az webelement-t és után kérjük le a
			// szövegét.
			String name = product.findElement(productNames).getText().trim();
			String price = product.findElement(productPrices).getText().trim();

			productData.add(List.of(name, price));
		}

		return productData;
	}

}
