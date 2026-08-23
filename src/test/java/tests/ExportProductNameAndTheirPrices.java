package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;

@Tag("ui")
@Tag("regression")
class ExportProductNameAndTheirPrices extends BaseTest {
	
	/**
	 * TC11 Adatok lementése felületről .csv fájlba.
	 * @throws Exception
	 */
	@Test
	@DisplayName("TC11 - Termékek exportálása CSV fájlba")
	void exportProductsToCsvTest() throws Exception {
		/* A HomePage-en van egy metódus
		, ami visszaadja a termékeket (név + ár párokként). */
		List<List<String>> productRows = homePage.getAllProductNamesAndPrices();
		
		// CSV fájl útvonala.
		Path csvPath = Path.of("target/artifacts/products-export.csv");
		
		// Létrehozzuk a mappa struktúrát, ha nem létezik.
		Files.createDirectories(csvPath.getParent());
		
		// CSV tartalom összeállítása.
		StringBuilder csvContent = new StringBuilder();
		
		// Fejléc beállítása.
		csvContent.append("Name,Price\n"); 
		
		for (List<String> row : productRows) {
			// Példa sor: "Combination Pliers","$14.15"
			csvContent.append("\"").append(row.get(0)).append("\",")
			          .append("\"").append(row.get(1)).append("\"\n");
		}
		
		// Kiírás fájlba.
		Files.writeString(csvPath, csvContent.toString());
		
		// Ellenőrzés, hogy létrejött-e a fájl.
		assertTrue(Files.exists(csvPath), "A CSV fájl nem jött létre!");
	}

}
