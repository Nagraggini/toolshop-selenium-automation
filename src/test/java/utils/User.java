package utils;

// Java 16-tól lehet ezt használni. Konstans változók. 
// Ez egy Java record deklaráció. 
// A record egy speciális Java osztálytípus, amelyet főként adatok tárolására használnak.
public record User(       
		String email,
        String firstName,
        String lastName,
        String dateOfBirth,
        String country,
        String zipcode,
        String houseNumber,
        String street,
        String city,
        String state,
        String mobile,
        String password
) {	}
