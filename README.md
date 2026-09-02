# vizsgaremek-fa-260117

Készítette: Freud Andrea

**Tesztelt webalkalmazás:** [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/)

**Teszt környezet:** Chrome böngésző; 1920×1080; internet hozzáférés

Futtatás:
linux-on és macOS-en: `./mvnw clean test`

windows-on: `mvnw clean test`

# Tech Stack

- Java 21;
- Maven;
- JUnit 5;
- Selenium WebDriver a UI tesztek készítéséhez;
- Page Object Model tervezési minta;
- Log4j a loggoláshoz (mentési helye: target/logs/test-execution.log);
- Git/GitHub a verziókezeléshez.
- A GitHub Actions futtatása során a teszteltoldal Cloudflare botvédelme miatt a tesztek nem futnak le, viszont helyi környezetben a tesztek sikeresen végrehajthatóak.

# Jelentés letöltése

Az jelentés megtalálható a GitHub-on az Actions fülön, ha az adott workflow-ra kattintunk lejebb görgetünk az Artifacts részen letölthető a `surfire-reports` egy zip-ben. 

Valamint offline a tesztek futtatása után a target mappában is megtalálható a `surefire-reports`.
