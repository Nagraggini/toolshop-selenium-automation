package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserFactory {

	public static User newRandomUser(
            String firstName,
            String lastName,
            String country,
            String zipcode,
            String houseNumber,
            String street,
            String city,
            String state,
            String mobile,
            String password
    ) {
        // Egyedi email generálása az időbélyeg alapján.      
        String email = TestData.generateEmail();

     // Az idei évből kivon 20-at, és YYYY-MM-DD formátumra alakítja (pl. 2006-01-01)
        String dateOfBirth = LocalDate.now().minusYears(20)
            .withMonth(1)
            .withDayOfMonth(1)
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        return new User(
                email,
                firstName,
                lastName,
                dateOfBirth,
                country,
                zipcode,
                houseNumber,
                street,
                city,
                state,
                mobile,
                password
        );
    }
}
