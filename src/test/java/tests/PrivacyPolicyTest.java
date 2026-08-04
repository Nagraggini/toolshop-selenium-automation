package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;

class PrivacyPolicyTest extends BaseTest {

	/**
	 * TC04 Adatkezelési nyilatkozat használata.
	 */
	@Test
	@DisplayName("TC04 - Adatkezelési nyilatkozat megnyitása és tartalmának ellenőrzése.")
	void checkPrivacyPolicyContainsTwoWordsTest() {	
		assertTrue(homePage.clickPrivacyPolicyLink()
				.verifyTwoWordsInPrivacyText("Data Removal", "Data Security"));
	}

}
