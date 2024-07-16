package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * Abstract base class for all page objects.
 * <p>
 * This class is intended to be extended by all page object classes in the test framework.
 * It provides a WebDriver instance and initializes the web elements using Selenium's PageFactory.
 * </p>
 */
//Forcing inheritance: declaring the Base class as abstract enforces the required implementation in subclasses, promoting code structuring and avoiding misuse.
public abstract class Base {
    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
