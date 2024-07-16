package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.BrowserFactory;
import utils.Configuration;
/**
 * Base test class for all test cases.
 * <p>
 * This class provides setup and teardown methods to initialize and clean up the WebDriver instance.
 * It is intended to be extended by all test classes in the test framework.
 * </p>
 */
public class BaseTest {
    protected WebDriver driver;
    /**
     * Sets up the WebDriver instance and navigates to the base URL of the specified environment.
     * <p>
     * This method runs before each test method, as indicated by the {@code @BeforeMethod} annotation.
     * It initializes the WebDriver, maximizes the browser window, deletes all cookies, and navigates to the base URL.
     * </p>
     *
     * @param browser the type of browser to use (e.g., "firefox" or "chrome"). Defaults to "firefox" if not specified.
     * @param environment the environment to test against (e.g., "dev" or "prod"). Defaults to "dev" if not specified.
     */
    @Parameters({"browser","environment"})
    @BeforeMethod
    //In TestNG, @BeforeMethod marks a method to run before each test, used for per-test setup.
    public void setUp(@Optional("firefox") String browser, @Optional("dev") String environment){
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(Configuration.getBaseUrl(environment));
    }
    /**
     * Tears down the WebDriver instance.
     * <p>
     * This method runs after each test method, as indicated by the {@code @AfterMethod} annotation.
     * It quits the WebDriver after a brief pause.
     * </p>
     *
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    @AfterMethod
    public void tearDown() throws InterruptedException {
        if(driver != null){
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
