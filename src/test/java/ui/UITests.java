package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

@Tag("ui")
public class UITests {
    private WebDriver driver;
    private String browser = System.getProperty("browser", "chrome");

    @BeforeEach
    void setUp() {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("UI Test Example - Open Google")
    @DisplayName("Verify Google Homepage")
    void openGoogle() {
        driver.get("https://google.com");
        Assertions.assertTrue(driver.getTitle().contains("Google"),
                "Page title should contain 'Google'");
    }
}