package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/** Itt csak a driverek vannak. */
public class DriverFactory {

    public static WebDriver createDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");     
        
        // Így localban, sem fog megnyílni a böngésző.
       //headless = true;

        if (headless) {
            options.addArguments("--headless=new");
        }

        // Teljesen elnémítja a CDP verziókereső hibaüzeneteit
        java.util.logging.Logger.getLogger("org.openqa.selenium.devtools.CdpVersionFinder")
                .setLevel(java.util.logging.Level.OFF);

        // Az összes Selenium figyelmeztetés elnémítása
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.SEVERE);

        return new ChromeDriver(options);
    }
}