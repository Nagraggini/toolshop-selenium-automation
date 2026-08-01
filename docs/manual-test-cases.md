# Vizsgaremek követelményeinek megfelelés

| Követelmények 								  | Teszteset 		 | Megjegyzés							      |			
| :---------------------------------------------- | :--------------- | :----------------------------------------- |		
| Regisztráció 									  | TC01 , TC02		 | 	Pozitív és negatív teszt                  |		
| Bejelentkezés									  | TC01			 |    										  |		
| Adatkezelési nyilatkozat használata 			  |  				 |       									  |		
| Adatok listázása							  	  | 		 		 |											  |		
| Több oldalas lista bejárás					  | TC01		 	 | TC01 nem kifejezetten több oldalas bejárás |		
| Új adat bevitel 								  |     			 | 										      |		
| Ismételt és sorozatos adatbevitel adatforrásból |  			 	 |     									 	  |		
| Meglévő adat módosítás						  | 			 	 |     										  |		
| Adat vagy adatok törlése 						  | 			 	 |    									      |		
| Adatok lementése felületről					  |  			 	 |     									      |		
| Kijelentkezés									  |  			 	 |     									      |			

# Manuális tesztesetek dokumentációja

## Cél

A dokumentum tartalmazza azokat a manuális teszteseteket,
amelyek alapján az automatizált Selenium tesztek elkészültek.

## TC01

Regisztráció
Cél: Új felhasználói fiók sikeres létrehozása.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Kattintás a jobb felső sarokban található hamburger ikonra aztán a "Sign in" linkre, majd a regisztrációs opció kiválasztása az alul lévő "Register your account" gomb segítségével.

A regisztrációs űrlap kitöltése érvényes adatokkal:

- Keresztnév és vezetéknév (First name, Last name)
- Születési dátum (Date of birth)
- Cím adatok (Country, Postal code, House number, Street, City, State)
- Telefonszám (Phone)
- Email cím (Email) és jelszó (Password)
- Jelszó követelmények: Minimum 8 karakter, kicsi és nagy betű is kötelező, legalább egy szám, legalább egy speciális karakter 
(@, #, $, stb.)

A "Register" gombra kattintás.

A rendszer sikeresen regisztrálja a felhasználót, és átirányít a bejelentkezési oldalra.

Bejelentkezünk az oldalra.

Elvárt eredmény: A sikeres bejelentkezés után megjelenik az üdvözlő üzenet, melynek ez a tartalma: 
"Here you can manage your profile, favorites and orders."

## TC02

Regisztráció
Cél: Új felhasználói fiók sikertelen létrehozása.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Kattintás a jobb felső sarokban található hamburger ikonra aztán a "Sign in" linkre, majd a regisztrációs opció kiválasztása az alul lévő "Register your account" gomb segítségével.

Keresztnév mezőt direkt üresen hagyjuk (First name)

A regisztrációs űrlap kitöltése érvényes adatokkal kivéve a keresztnév mezőt:

- Vezetéknév (Last name)
- Születési dátum (Date of birth)
- Cím adatok (Country, Postal code, House number, Street, City, State)
- Telefonszám (Phone)
- Email cím (Email) és jelszó (Password)
- Jelszó követelmények: Minimum 8 karakter, kicsi és nagy betű is kötelező, legalább egy szám, legalább egy speciális karakter 
(@, #, $, stb.)

A "Register" gombra kattintás.

A rendszer kiírja, hogy sikertelen a regisztráció.


Elvárt eredmény: Sikertelen a regisztráció és a keresztnév alatt megjelenik egy hibaüzenet: 
"First name is required"



