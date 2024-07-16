package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Factory class for creating WebDriver instances based on the specified browser type.
 */
public class BrowserFactory {
    /**
     * Creates a new WebDriver instance based on the specified browser type.
     *
     * @param browser the type of browser to create the WebDriver for (e.g., "firefox" or "chrome").
     * @return a WebDriver instance for the specified browser.
     * @throws IllegalArgumentException if the specified browser type is invalid.
     */
    public static WebDriver getDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.ghecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser invalid: " + browser);
        }
        return driver;
    }
}
