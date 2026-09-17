# Toolshop Selenium Automation

Tested web application: https://practicesoftwaretesting.com/

# Execution

On Linux and macOS: `./mvnw clean test`

On Windows: `mvnw clean test`

# Tech Stack

* Java 21;
* Maven;
* JUnit 5;
* Selenium WebDriver for creating UI tests;
* Page Object Model design pattern;
* Log4j for logging (log file location: `target/logs/test-execution.log`);
* Git/GitHub for version control.
* When running the tests through GitHub Actions, the tests fail to execute due to the Cloudflare bot protection on the tested website. However, the tests execute successfully in a local environment.

# Downloading the Report

The report can be found on GitHub under the **Actions** tab. Click on the relevant workflow, scroll down to the **Artifacts** section, and download `surefire-reports` as a ZIP file.

The `surefire-reports` folder is also available offline in the `target` directory after running the tests.
