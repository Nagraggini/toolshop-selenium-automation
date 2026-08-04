package utils;

import java.security.SecureRandom;

public class TestData {

    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;

    // Karakter készletek konstansként definiálva
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "@#$%&*!";
    
    private static final SecureRandom random = new SecureRandom();
    
    public TestData() {
        this.email = generateEmail();
        this.password = generateRandomPassword();
        this.firstName = "Sam";
        this.lastName = "Smith";
    }

    /**
     * Általános metódus karakterek véletlenszerű generálására megadott karakterkészletből.
     */
    private static String generateRandomString(String characterPool, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }
        return sb.toString();
    }

    public static String generateEmail() {
        String allCharacters = UPPERCASE + LOWERCASE + NUMBERS;

        // Kötelező karakterek + maradék a 8 karakterhez (4 karakter generálása)
        StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        emailBuilder.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        emailBuilder.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        emailBuilder.append(generateRandomString(allCharacters, 4));

        return "test" + System.currentTimeMillis() + emailBuilder.toString() + "@test.com";
    }

    private String generateRandomPassword() {
        String allCharacters = UPPERCASE + LOWERCASE + NUMBERS + SPECIAL;

        // Kötelező karakterek + maradék a 8 karakterhez (4 karakter generálása)
        StringBuilder passwordBuilder = new StringBuilder();
        passwordBuilder.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        passwordBuilder.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        passwordBuilder.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        passwordBuilder.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));
        passwordBuilder.append(generateRandomString(allCharacters, 4));

        return passwordBuilder.toString();
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