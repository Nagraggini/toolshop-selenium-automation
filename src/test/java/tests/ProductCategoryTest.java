package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;

@Tag("ui")
@Tag("regression")
class ProductCategoryTest extends BaseTest{

	/**
	 * TC07 Több oldalas lista bejárása.
	 */
	@Test
	@DisplayName("TC07 - Termékek listázása és kategóriák bejárása.")
	void listProductsAndTraverseCategories() {
		assertTrue(homePage.clickHandToolsCategory().getAllProductNames().size() > 0);
		assertTrue(homePage.clickHandPowerToolsCategory().getAllProductNames().size() > 0);
		assertTrue(homePage.clickHandOtherCategory().getAllProductNames().size() > 0);
		assertEquals("There are no products found.", homePage.clickSpecialToolsCategory()
				.getNoProductsMessage());
	}
}
