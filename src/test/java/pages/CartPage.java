package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	private final By continueShoppingBtn = By.cssSelector("[data-test='continue-shopping']");
	
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
         return getText(By.xpath("//tr[td/*[@data-test='product-title' and contains(text(), '"+
        		productName+"')]]"
        		+ "//input[@data-test='product-quantity']"));
    }    
}
