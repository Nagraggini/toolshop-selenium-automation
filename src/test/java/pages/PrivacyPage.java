package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrivacyPage extends BasePage {
	
	private final By privacyPolicyText = By.xpath("//strong[contains(normalize-space(),'Privacy Policy')]");
	
	// Maga a privacy szekció.
	private final By privacyContainer = By.cssSelector("app-privacy");
	
	public PrivacyPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyText));
	}

	public boolean verifyTwoWordsInPrivacyText(String word1, String word2) {
	    // 1. Leszedjük az egész szöveget a konténerből
	    String fullText = driver.findElement(privacyContainer).getText();
	    
	    // 2. Csekkoljuk a két szót.
	    boolean containsFirstWord = fullText.contains(word1);
	    boolean containsSecondWord = fullText.contains(word2);
	    
	    // Igaz lesz a visszatérési értéke, ha mindkét szó benne van a szövegben. 
	    return containsFirstWord && containsSecondWord;
	}
}
