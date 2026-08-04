package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.HomePage;

class ContactUsTest extends BaseTest{

	/**
	 * TC08 Új adat bevitel. Fájlfeltöltéssel kombinált kapcsolatfelvétel teszt.
	 */
	    @Test
	    @DisplayName("TC08 - Új adat bevitel.")
	    void contactUsSubmitForm() {
	        ContactPage contact = new HomePage(driver).clickContact();

	        Path file = Path.of("src/test/resources/upload/testfile.txt").toAbsolutePath();

	        contact.fillForm("User", "Test", "test@example.test", "return",
	        		"Message from UI test. Message from UI test. Message from UI test. Message from UI test. ")
	               .uploadAttachment(file.toString()) 
	               .clickSubmit();

	        assertTrue(contact.isSuccessVisible());
	        assertEquals("Thanks for your message! We will contact you shortly."
	        		,contact.getSuccessMessage());
	    }
}
