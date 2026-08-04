package utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Kiolvassa az adatokat a környezeti változók fájljából (gyökér könyvtárban van a .env fájl).
 */
public class ConfigReader {

	private static final Dotenv dotenv = Dotenv.configure().load();

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
