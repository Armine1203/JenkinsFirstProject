package ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Tag("ui")
public class UITests {

    WebDriver driver;

    @Test
    @Description("UI Test Example - Open Google")
    void openGoogle() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.get("https://google.com");
        assert driver.getTitle().contains("Google");

        driver.quit();
    }
}
