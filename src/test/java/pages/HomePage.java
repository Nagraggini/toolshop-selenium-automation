package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	private final By pageLogo = By.cssSelector("a.navbar-brand");
	
	// A kategória menü lenyitása. 
	private final By categoriesDropdown = By.cssSelector("[data-test='nav-categories']");
	private final By contactBtn = By.cssSelector("[data-test='nav-contact']");
	private final By signInBtn = By.cssSelector("[data-test='nav-sign-in']");	
	
	private final By privacyPolicyLink = By.cssSelector("[routerlink='privacy']");
	private final By productNames = By.cssSelector("[data-test='product-name']");
		
	private final By handToolsCategory = By.cssSelector("a[data-test='nav-hand-tools']");
	private final By handPowerToolsCategory = By.cssSelector("a[data-test='nav-power-tools']");
	private final By handOtherCategory = By.cssSelector("a[data-test='nav-other']");
	private final By specialToolsCategory = By.cssSelector("a[data-test='nav-special-tools']");
	
	private final By noProductsMessage = By.cssSelector("[data-test='category-empty']");
		
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
	    click(signInBtn);
	    return new LoginPage(driver);
	}	
	
	public PrivacyPage clickPrivacyPolicyLink() {	
	    click(privacyPolicyLink);
	    return new PrivacyPage(driver);
	}
	
	public List<String> getAllProductNames() {
	    // Megvárjuk, hogy megjelenjenek a termékkártyák.
	    waitForAllElementsPresent(productNames);

	    List<WebElement> productNameElements = findAll(productNames);

	    List<String> productNames = new ArrayList<>();

	    for (WebElement itemName : productNameElements) {
	        // trim() eltávolítja a felesleges szóközöket az elejéről és a végéről.
	        productNames.add(itemName.getText().trim());
	    }

	    return productNames;
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
	 *  pl.: Combination Pliers
	 */
	public ProductPage clickSpecificItem(String productName) {
		By specProduct = By.xpath("//h5[@data-test='product-name' and normalize-space()='"+productName+"']");
		click(specProduct);
		return new ProductPage(driver);
		
	}
	
}
