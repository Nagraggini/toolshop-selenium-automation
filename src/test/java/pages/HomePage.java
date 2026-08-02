package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	private final By pageLogo = By.cssSelector("a.navbar-brand");
	
	private final By sigInBtn = By.cssSelector("[data-test='nav-sign-in']");	
	private final By privacyPolicyLink = By.cssSelector("[routerlink='privacy']");
	private final By productItemCards = By.cssSelector("[data-test='product-name']");
	
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
	
	public PrivacyPage clickPrivacyPolicyLink() {	
	    click(privacyPolicyLink);
	    return new PrivacyPage(driver);
	}
	
	public List<String> getAllProductNames() {
	    // Megvárjuk, hogy megjelenjenek a termékkártyák.
	    waitForAllElementsPresent(productItemCards);

	    List<WebElement> productNameElements = findAll(productItemCards);

	    List<String> productNames = new ArrayList<>();

	    for (WebElement itemName : productNameElements) {
	        // trim() eltávolítja a felesleges szóközöket az elejéről és a végéről.
	        productNames.add(itemName.getText().trim());
	    }

	    return productNames;
	}
}
