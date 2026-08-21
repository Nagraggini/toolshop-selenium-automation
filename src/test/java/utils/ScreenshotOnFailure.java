package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFailure
        implements AfterTestExecutionCallback {

    private final Supplier<WebDriver> driverSupplier;

    public ScreenshotOnFailure(
            Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isEmpty()) {
            return;
        }

        WebDriver driver = driverSupplier.get();

        if (driver == null) {
            return;
        }

        takeScreenshot(driver, context.getDisplayName());
    }

    private void takeScreenshot(WebDriver driver, String testName) {
        try {
            File sourceFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String safeTestName = testName.replaceAll(
                    "[^a-zA-Z0-9-_]", "_"
            );

            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")
            );

            // A target/screenshots/ mappába mentjük a képeket. 
            Path screenshotDirectory = Path.of(
                    "target", "screenshots"
            );

            Files.createDirectories(screenshotDirectory);

            Path destination = screenshotDirectory.resolve(
                    safeTestName + "_" + timestamp + ".png"
            );

            Files.copy(sourceFile.toPath(), destination);

            System.out.println(
                    "Screenshot saved: "
                    + destination.toAbsolutePath()
            );

        } catch (IOException exception) {
            System.err.println(
                    "Could not save screenshot: "
                    + exception.getMessage()
            );
        }
    }
}