package base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	// Logoláshoz.
	protected static final Logger logger = LogManager.getLogger(BasePage.class);

	// KONSTRUKTOR: Ezen keresztül adjuk át a futó böngészőt a tesztből.
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// I. find() - legalacsonyabb szintű művelet
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	// II. "okos réteg" a Wait wrapperek, a várakoztatások:
	protected WebElement waitUntilVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected WebElement waitUntilClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected WebElement waitUntilPresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected List<WebElement> waitForAllElementsPresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	protected void waitAttribute(By locator, String attribute, String value) {
		wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	}

	/** Leellenőrizzük, hogy betöltött-e az adott komponens szövege. */
	protected Boolean waitUntilTextToBe(By locator, String text) {
		return wait.until(ExpectedConditions.textToBe(locator, text));
	}

	// III. kényelmi metódusok, interakciók
	protected void click(By locator) {
		logger.info(" Clicking on element: {}", locator);
		waitUntilClickable(locator).click();
	}

	protected void type(By locator, String text) {
		waitUntilVisible(locator).sendKeys(text);
	}

	protected void clearAndType(By locator, String text) {
		WebElement element = waitUntilVisible(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(By locator) {
		return waitUntilVisible(locator).getText();
	}

	protected boolean isDisplayed(By locator) {
		try {
			return waitUntilVisible(locator).isDisplayed();
		} catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	/** Egy HTML elem valamelyik attribútumának értékének kiolvasásához. */
	protected String getAttribute(By locator, String attribute) {
		return waitUntilVisible(locator).getAttribute(attribute);
	}

	/** Középre görgetés. */
	// Ez is kell hozzá: import org.openqa.selenium.JavascriptExecutor;
	protected void scrollToElement(By locator) {
		WebElement element = waitUntilVisible(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].scrollIntoView({block: 'center'});",
				element);
	}

	// IV. select
	protected Select select(By locator) {
		return new Select(waitUntilVisible(locator));
	}

	protected void selectByValue(By locator, String value) {
		select(locator).selectByValue(value);
	}

	protected void selectByVisibleText(By locator, String text) {
		select(locator).selectByVisibleText(text);
	}

	// V. URL műveletek
	/*
	 * public void openPage(String url) {
	 * this.driver.get(url);
	 * }
	 */
	public void clearCookies() {
		driver.manage().deleteAllCookies();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void refreshPage() {
		this.driver.navigate().refresh();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	/** Lekéri az aktuális böngészőablak vagy tab azonosítóját (window handle). */
	protected String getCurrentTab() {
		return driver.getWindowHandle();// Az aktuális ablak azonosítójának a lekérése, ami Selenium által generált.
	}

	/** Átváltás az új fülre. */
	protected void switchToNewTab() {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(driver.getWindowHandle())) {
				driver.switchTo().window(tab);
				return;
			}
		}
	}

	/**
	 * A metódus bezárja az aktuálisan megnyitott böngészőtabot vagy ablakot, majd
	 * visszavált a megadott eredeti tabra.
	 */
	protected void closeCurrentTabAndSwitchBack(String originalTab) {
		driver.close();
		driver.switchTo().window(originalTab);
	}
}