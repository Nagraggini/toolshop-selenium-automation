package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import base.BaseTest;

class ProductListTest extends BaseTest{

	/**
	 * TC05 Adatok listázása.
	 */
	@Test
	@DisplayName("TC05 - A főoldalon lévő terméklista 9 db terméket tartalmaz.")
	void productListTest() {
		assertEquals(9, homePage.getAllProductNames().size());
	}
	
	/**
	 * TC06 Adatok nevének ellenőrzése.
	 */

	@ParameterizedTest
    @CsvSource({ "Combination Pliers", "Pliers","Bolt Cutters",
    	"Long Nose Pliers","Slip Joint Pliers", "Claw Hammer with Shock Reduction Grip"
    	,"Hammer","Claw Hammer", "Thor Hammer"})
    @Tag("ui")
    @Tag("regression")    
    @DisplayName("Leellenőrizzük, hogy az összes termék neve megjelenik-e.")
    void checkProductNamesTest(String itemName) {
           assertTrue(homePage.getAllProductNames().contains(itemName),
        		    "Ez a termék nem található: " + itemName);
    }
	
}
