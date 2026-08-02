package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='specs-title']");
	
	private final By cartIcon = By.cssSelector("[data-test='nav-cart']");
	
	private final By quantity = By.cssSelector("[data-test='quantity']");
	private final By addToCartBtn = By.cssSelector("[data-test='add-to-cart'");
	
	public ProductPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Specifications"));
	}
	
	/**
	 * Ennyi darab terméket rakunk a kosárba.
	 */
	public ProductPage changeQuantity(String pieces) {
		type(quantity, pieces);
		click(addToCartBtn);
		return new ProductPage (driver);
	}

	/**
	 *  Kosárba rakjuk a terméket. 
	 */
	public ProductPage addToCart() {
		click(addToCartBtn);
		return new ProductPage (driver);
	}
	
	/**
     * Rákattint a kosár ikonra a navigációs sávban, és átnavigál a kosár oldalra.
     */
    public CartPage clickCart() {
        click(cartIcon);
        return new CartPage(driver);
    }
	
}
