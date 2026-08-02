package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

	private final By pageTitle = By.xpath("//h3[normalize-space()='Contact']");
	
	// Mezők lokátorai
	private final By firstNameInput = By.cssSelector("[data-test='first-name']");
	private final By lastNameInput = By.cssSelector("[data-test='last-name']");
	private final By emailInput = By.cssSelector("[data-test='email']");
	private final By subjectSelect = By.cssSelector("[data-test='subject']");
	private final By messageTextArea = By.cssSelector("[data-test='message']");
	private final By attachmentInput = By.cssSelector("[data-test='attachment']");	
	
	// Gomb
	private final By submitBtn = By.cssSelector("[data-test='contact-submit']");
	
	// Visszajelzés / Sikeres elküldés üzenete
	private final By successMessage = By.cssSelector("div[role='alert'].alert-success");
	
	public ContactPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBe(pageTitle, "Contact"));
	}
	
	public ContactPage fillFirstName(String firstName) {
		type(firstNameInput, firstName);
		return this;
	}

	public ContactPage fillLastName(String lastName) {
		type(lastNameInput, lastName);
		return this;
	}

	public ContactPage fillEmail(String email) {
		type(emailInput, email);
		return this;
	}

	public ContactPage selectSubject(String subjectValue) {
		selectByValue(subjectSelect, subjectValue);
		return this;
	}

	/**
	 *  Minimum 50 karakter.
	 */
	public ContactPage fillMessage(String message) {
		type(messageTextArea, message);
		return this;
	}

	/**
	 *  Üresnek kell lennie a fájlnak.
	 */
	public ContactPage uploadAttachment(String filePath) {
		type(attachmentInput, filePath); 
		return this;
	}
	
	public ContactPage fillForm(String pFirstName, String pLastName, String pEmail, String pSubject, String pMessage) {
		type(firstNameInput, pFirstName);
		type(lastNameInput, pLastName);
		type(emailInput, pEmail);
		selectByValue(subjectSelect, pSubject);
		type(messageTextArea, pMessage); // Minimum 50 karakter.
		return this;
	}

	public ContactPage clickSubmit() {
		click(submitBtn);
		return this;
	}

	public boolean isSuccessVisible() {
		return isDisplayed(successMessage);
	}
	
	/**
	 *  Megjelennő üzenet: "Thanks for your message! We will contact you shortly."
	 */
	public String getSuccessMessage() {
		return getText(successMessage);
	}
	
}	