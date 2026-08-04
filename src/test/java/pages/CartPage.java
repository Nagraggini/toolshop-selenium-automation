package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	private final By homeBtn = By.cssSelector("[data-test='nav-home']");
			
	private final By continueShoppingBtn = By.cssSelector("[data-test='continue-shopping']");
	private final By emptyCartMessage=
			By.xpath("//p[normalize-space()='The cart is empty. Nothing to display.']");
	
	public CartPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(continueShoppingBtn, "Continue Shopping"));
	}

	/**
     * Rákattint a "Continue Shopping" gombra, és visszatér a főoldalra.
     */
    public HomePage clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
        return new HomePage(driver);
    }
    
    /**
     * Terméknév alapján megkeresi a törlés gombot és törli a terméket a kosárból.
     * pl. "Combination Pliers"
     */
    public CartPage clickDeleteButtonByProductName(String productName) {
    	click(By.xpath("//tr[td/*[@data-test='product-title' and contains(text(), '"+productName+"')]]"
        		+ "//a[contains(@class, 'btn-danger')]"));       
        return new CartPage(driver);
    }

    /**
     * Terméknév alapján megkeresi a mennyiség input mezőt.
     * pl. "Claw Hammer with Shock Reduction Grip"
     */
    public String getQuantityInputByProductName(String productName) {
    	// Mivel inpu mező, ezért nem elég a getText() metódus.
         return waitUntilPresent(By.xpath("//tr[td/*[@data-test='product-title' and contains(text(), '"+
        		productName+"')]]"
        		+ "//input[@data-test='product-quantity']")).getAttribute("value");
    }
    
    /**
     * 
     * Megnézi, hogy a "The cart is empty. Nothing to display."
     * szöveg létezik-e a DOM fában és látható-e.
     */
    public Boolean emptyCartMessageVisible() {
    	return waitUntilVisible(emptyCartMessage).isDisplayed(); 
    }
    
    /**
	 * Visszatérünk a főoldalra.
	 */
	public HomePage clickHome() {
		click(homeBtn);
		return new HomePage(driver);
	}
	
	

}
