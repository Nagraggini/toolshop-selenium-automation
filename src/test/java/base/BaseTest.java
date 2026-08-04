package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import pages.HomePage;
import utils.TestData;

public class BaseTest {

	protected WebDriver driver;
	// 10 másodperces várakoztatás deklarálása.
	protected WebDriverWait wait;

	// Logoláshoz.
	protected static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	protected HomePage homePage;
	protected TestData testData;
	
	@BeforeEach
	void setUp(org.junit.jupiter.api.TestInfo testInfo) {		
		driver = DriverFactory.createDriver(System.getProperty("CI") != null); // headless CI-ben
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Kiírjuk a logba az induló teszt nevét.
        logger.info("//==================================================");
        logger.info(" TESZT NEVE: " + testInfo.getDisplayName());
        logger.info("//==================================================");
        
		homePage = new HomePage(driver);
		homePage.open();
		testData=new TestData();
	}

	
	@AfterEach
	void tearDown(org.junit.jupiter.api.TestInfo testInfo) {
		// Kiírjuk a logba az induló teszt nevét.
		  logger.info("//==================================================");
	      logger.info(" 		TESZT VÉGE");
	      logger.info("//==================================================");
	        
	        
		// Bezárja az összes ablakot és teljesen leállítja a WebDriver-t.
		if (driver != null) {
			driver.quit();
		}
	}

	protected void onlyForChecking() {
		// Csak ellenőrzéshez.
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}