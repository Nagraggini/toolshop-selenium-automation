package utils;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UsersCsv {

    public static List<User> loadUsersFromResource(String resourcePath) {
        InputStream is = UsersCsv.class
                .getClassLoader()
                .getResourceAsStream(resourcePath);

        if (is == null) {
            throw new IllegalArgumentException("Nem találom a resource-t: " + resourcePath);
        }

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            List<User> users = new ArrayList<>();

            // Fejléc átugrása.
            reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null) {
                // A képen látható sorrend alapján:
                              
                String firstName = row[0];
                String lastName = row[1];                
                String country = row[2];
                String zipcode = row[3];
                String houseNumber = row[4];
                String street = row[5];
                String city = row[6];
                String state = row[7];
                String mobile = row[8];
                String password = row[9];

                User user = UserFactory.newRandomUser(
                        firstName, lastName, country, zipcode, 
                        houseNumber, street, city, state, mobile, password
                );

                users.add(user);
            }

            return users;

        } catch (Exception e) {
            throw new RuntimeException("Hiba a CSV feldolgozásakor", e);
        }
    }
}