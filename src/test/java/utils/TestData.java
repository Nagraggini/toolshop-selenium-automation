package utils;

import java.util.Random;

public class TestData {

    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;

    public TestData() {
        this.email = generateEmail();
        this.password = generateRandomPassword();
        this.firstName = "Sam";
        this.lastName = "Smith";
    }

    private String generateEmail() {
        return "test" + System.currentTimeMillis() + "@test.com";
    }

    private String generateRandomPassword() {

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "@#$%&*!";

        String allCharacters = uppercase + lowercase + numbers + special;

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        // Kötelező karakterek
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Minimum 8 karakter
        for (int i = 4; i < 8; i++) {
            password.append(
                allCharacters.charAt(random.nextInt(allCharacters.length()))
            );
        }

        return password.toString();
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}