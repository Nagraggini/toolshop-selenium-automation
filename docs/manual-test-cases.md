# Vizsgaremek követelményeinek megfelelés

| Követelmények 								  | Teszteset 		 | Megjegyzés							      |			
| :---------------------------------------------- | :--------------- | :----------------------------------------- |		
| Regisztráció 									  | TC01 , TC02		 | 	Pozitív és negatív teszt                  |		
| Bejelentkezés									  | TC03			 |    										  |		
| Adatkezelési nyilatkozat használata 			  | TC04			 |       									  |		
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

Az alábbiakban részletesen, a vizsgaremek követelményeihez igazítva összegyűjtöttem a lépéseket és a teszteseteket a Practice Software Testing - Toolshop ([https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/)) webalkalmazáshoz, amely minden kötelező funkciót lefed.

## TC01

Regisztráció
Teszt rövid leírása: Új felhasználói fiók sikeres létrehozása.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Kattintás a jobb felső sarokban található hamburger ikonra aztán a "Sign in" linkre, majd a regisztrációs opció kiválasztása az alul lévő "Register your account" gomb segítségével.

A regisztrációs űrlap kitöltése random adatokkal:

- Keresztnév és vezetéknév (First name, Last name)
- Születési dátum (Date of birth)
- Cím adatok (Country, Postal code, House number, Street, City, State)
- Telefonszám (Phone)
- Email cím (Email) és jelszó (Password)
- Jelszó követelmények: Minimum 8 karakter, kicsi és nagy betű is kötelező, legalább egy szám, legalább egy speciális karakter 
(@, #, $, stb.)

A "Register" gombra kattintás.

A rendszer sikeresen regisztrálja a felhasználót, és átirányít a bejelentkezési oldalra.

Bejelentkezünk az oldalra az újonnan regisztrált email címmel és jelszóval.

Elvárt eredmény: A sikeres bejelentkezés után megjelenik az üdvözlő üzenet, melynek ez a tartalma: 
"Here you can manage your profile, favorites and orders."

## TC02

Regisztráció
Teszt rövid leírása: Új felhasználói fiók sikertelen létrehozása.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Kattintás a jobb felső sarokban található hamburger ikonra aztán a "Sign in" linkre, majd a regisztrációs opció kiválasztása az alul lévő "Register your account" gomb segítségével.

Keresztnév mezőt direkt üresen hagyjuk (First name)

A regisztrációs űrlap kitöltése random adatokkal kivéve a keresztnév mezőt:

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

## TC03

Bejelentkezés
Teszt rövid leírása: A regisztrált fiókkal való sikeres belépés.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Kattintás a jobb felső sarokban található hamburger ikonra aztán a "Sign in" linkre.

Az email cím és a jelszó megadása az "Email address" és a "Password" mezőkben.
A teszt felhasználó adatai a gyökér könyvtárban lévő .env fájlban találhatóak.

A "Login" gombra kattintás.

Elvárt eredmény: A felhasználó sikeresen belép, a felül a hamburger ikonra kattintás után megjelenik a felhasználó teljes neve.

## TC04

Adatkezelési nyilatkozat használata
Teszt rövid leírása: Az adatvédelmi / ÁSZF / jogi nyilatkozat elérhetőségének és tartalmának validálása.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

Az oldal láblécében (footer) található "Privacy Policy" gombra kattintás.

Megjelenik az adatvédelmi nyilatkozat, melynek a tartalmát ellenőrizzük, hogy megtalálhatóak-e benne a kulcsszavak: "Data Removal", "Data Security"

Elvárt eredmény: Az adatkezelési nyilatkozat oldala hibátlanul betöltődik, és a kötelező jogi szöveg megjelenik a felületen ("Data Removal", "Data Security").

## TC05

Adatok listázása
Teszt rövid leírása: A termékek vagy elemek listájának megjelenítése a felületen.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

A termék kártyák betöltődésének megvárása.

Elemek darabszámának ellenőrzése. (9 db)

Elvárt eredmény: A termékek listája hiba nélkül betöltődik, és a tételek láthatóvá válnak a felhasználó számára.

## TC06

Termékek meglétének ellenőrzése

Teszt rövid leírása: A megjelenő terméklistában ellenőrizzük, hogy az elvárt termékek megtalálhatóak-e.

Teszt lépések:

Navigáció a [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/) weboldalra.

A termék kártyák betöltődésének megvárása.

A terméknevek lekérése a felületről.

Az elvárt terméknevek ellenőrzése a listában:
   - Combination Pliers
   - Pliers
   - Bolt Cutters
   - Long Nose Pliers
   - Slip Joint Pliers
   - Claw Hammer with Shock Reduction Grip
   - Hammer
   - Claw Hammer
   - Thor Hammer

Elvárt eredmény:
A terméklista tartalmazza az összes elvárt terméket, és azok nevei megfelelően megjelennek a felhasználói felületen.

