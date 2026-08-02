package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.User;
import utils.UsersCsv;

class BulkRegistrationFromCsvTest extends BaseTest{

	/**
     * TC09 Ismételt és sorozatos adatbevitel adatforrásból
     */
    @Test
    void registerMultipleUsersFromCsv() {
        // Betöltjük a felhasználókat a CSV/Excel erőforrásból.
        List<User> users = UsersCsv.loadUsersFromResource("data/users.csv");
        assertFalse(users.isEmpty(), "A felhasználók listája nem lehet üres!");

        for (User u : users) {
            // Megnyitjuk a főoldalt
            HomePage homePage = new HomePage(driver);
            homePage.open();

            // Navigáció a regisztrációs oldalra (Home -> Sign In -> Register).
            LoginPage loginPage = homePage.clickSignIn();
            RegisterPage registerPage = loginPage.clickRegister();

            // Űrlap kitöltése a CSV-ből / User recordból származó adatokkal.
            registerPage
                    .fillFirstName(u.firstName())
                    .fillLastName(u.lastName())
                    .fillDateOfBirth(u.dateOfBirth())
                    .fillStreet(u.street())
                    .fillHouseNumber(u.houseNumber())
                    .fillPostalCode(u.zipcode())
                    .fillCity(u.city())
                    .fillState(u.state())
                    .selectCountry(u.country())
                    .fillPhone(u.mobile())
                    .fillEmail(u.email())
                    .fillPassword(u.password())
                    .clickRegister(); // Visszaadja a LoginPage-t sikeres regisztráció után

            // Bejelentkezés az újonnan regisztrált fiókkal
            // A sikeres regisztráció után a Login oldalra dob át a rendszer.
            loginPage.fillEmail(u.email())
                     .fillPassword(u.password());
            
            AccountPage loggedInAccount = loginPage.clickLogin();

            // Ellenőrzés, hogy sikeres volt-e a bejelentkezés (My account oldal betöltődött).
            assertNotNull(loggedInAccount.getUserFullName(), 
            		"A felhasználó nevének látszódnia kell a menüben!");

            // Kijelentkezés a következő kör előtt (ha szükséges, vagy törlés ha biztosítva van).
            loggedInAccount.clickSignOut();
        }
        
        // Pár perc múlva törli automatikusan a felhasználókat a rendszer.
    }
}
