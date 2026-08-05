package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

	private final By pageTitle = By.cssSelector("[data-test='specs-title']");
	
	// Felugrú toast üzenet, ha valamit berakunk a kosárba.
	private final By toastMessage = By.cssSelector(".ngx-toastr");
    
	private final By cartIcon = By.cssSelector("[data-test='nav-cart']");
	
	private final By quantity = By.cssSelector("[data-test='quantity']");
	private final By addToCartBtn = By.cssSelector("[data-test='add-to-cart']");
	
	public ProductPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Specifications"));
	}
	
	/**
	 * Ennyi darab terméket rakunk a kosárba.
	 */
	public ProductPage changeQuantityAndAddToCart(String pieces) {
		clearAndType(quantity, pieces);
		click(addToCartBtn);
		return new ProductPage (driver);
	}

	/**
	 *  Kosárba rakjuk a terméket. 
	 */
	public ProductPage addToCart() {
		click(addToCartBtn);
		return this;
	}
	
	/**
     * Rákattint a kosár ikonra a navigációs sávban, és átnavigál a kosár oldalra.
     */
	public CartPage clickCart() {
        // Megvárjuk, hogy a kosár ikon jelen legyen a DOM-ban.
        WebElement cartElement = wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon));
        
        // JavaScript kattintással kényszerítjük ki, így a toast üzenet nem zavar be
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cartElement);
        
        return new CartPage(driver);
    }
	
}
