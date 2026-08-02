package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.ConfigReader;

class PrivacyPolicyTest extends BaseTest {

	/**
	 * TC04 Adatkezelési nyilatkozat használata.
	 */
	@Test
	void usePrivacyPolicyTest() {		
		assertTrue(homePage.clickPrivacyPolicyLink()
				.verifyTwoWordsInPrivacyText("Data Removal", "Data Security"));
	}

}
