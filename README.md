# vizsgaremek-fa-260117

Készítette: Freud Andrea

Tesztelt webalkalmazás: [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/)

Futattás:
linux-on: `./mvnw clean test`

win-on: `mvnw clean test`

# Tech Stack

- Java 21;
- Maven;
- JUnit 5;
- Selenium WebDriver a UI tesztek készítéséhez;
- Page Object Model tervezési minta;
- Log4j a loggoláshoz (mentési helye: target/logs/test-execution.log);
- Git/GitHub Actions a verziókezeléshez és az automatikus teszt futtatáshoz.

# Jelentés letöltése

Az artifact-t megtalálható a github actions-ben, ha az adott workflow-ra kattintunk és alul a `surfire-reports` letölthető egy zip-ben. 
