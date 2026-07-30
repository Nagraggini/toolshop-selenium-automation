package utils;

public class TestData {

    public static String generateEmail() {
        return "test" + System.currentTimeMillis() + "@test.com";
    }

    public static String generatePassword() {
        return "Password123";
    }

    public static String generateFirstName() {
        return "Sam";
    }

    public static String generateLastName() {
        return "Smith";
    }
}