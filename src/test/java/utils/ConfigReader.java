package utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Kiolvassa az adatokat a környezeti változók fájljából (gyökér könyvtárban van a .env fájl).
 */
public class ConfigReader {

	private static final Dotenv dotenv = Dotenv.configure().load();
	
    private static final String DEFAULT_BASE_URL =
            "https://practicesoftwaretesting.com";

    public static String getBaseUrl() {
        return System.getProperty(
                "base.url",
                System.getenv().getOrDefault(
                        "BASE_URL",
                        DEFAULT_BASE_URL
                )
        );
    }
    
    // Admin felhasználó adatai
    public static String getAdminEmail() {
        return dotenv.get("ADMIN_EMAIL");
    }

    public static String getAdminPassword() {
        return dotenv.get("ADMIN_PASSWORD");
    }

    // Jane felhasználó adatai
    public static String getJaneEmail() {
        return dotenv.get("USER_JANE_EMAIL");
    }

    public static String getJanePassword() {
        return dotenv.get("USER_JANE_PASSWORD");
    }

    // Jack felhasználó adatai
    public static String getJackEmail() {
        return dotenv.get("USER_JACK_EMAIL");
    }

    public static String getJackPassword() {
        return dotenv.get("USER_JACK_PASSWORD");
    }

    // Bob felhasználó adatai
    public static String getBobEmail() {
        return dotenv.get("USER_BOB_EMAIL");
    }

    public static String getBobPassword() {
        return dotenv.get("USER_BOB_PASSWORD");
    }
    
}
