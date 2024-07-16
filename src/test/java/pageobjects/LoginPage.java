package pageobjects;

import base.Base;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Model class for the Login Page.
 * <p>
 * This class contains WebElements and methods for interacting with the login page,
 * including entering credentials, handling the "Remember Me" checkbox, and signing in.
 * </p>
 */
public class LoginPage extends Base {
    @FindBy(id = Config.USERNAME_FIELD_ID)
    private WebElement usernameField;

    @FindBy(id = Config.PASSWORD_FIELD_ID)
    private WebElement passwordField;

    @FindBy(xpath = Config.REMEMBER_CHECKBOX_XPATH)
    private WebElement rememberCheckbox;

    @FindBy(xpath = Config.SIGN_IN_BUTTON_XPATH)
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        // By calling super(driver);, you ensure that this initialization takes place before using the page elements in the subclass.
        super(driver);
    }
    /**
     * Enters the specified username and password into the respective fields.
     * <p>
     * This method waits for 5 seconds after entering the credentials.
     * </p>
     *
     * @param username the username to be entered.
     * @param password the password to be entered.
     */
    public void enterCredentials(String username,String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        try{
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("There was an interruption while waiting: " + e.getMessage());
        }
    }
    /**
     * Sets the "Remember Me" checkbox to the specified state.
     * <p>
     * If the checkbox is not already in the desired state, it clicks the checkbox to change its state.
     * </p>
     *
     * @param rememberMe the desired state of the "Remember Me" checkbox.
     */
    public void clickRememberCheckbox(boolean rememberMe) {
        if(rememberCheckbox.isSelected() != rememberMe){
            rememberCheckbox.click();
        }
    }
    /**
     * Clicks the "Sign In" button to submit the login form.
     * <p>
     * This method waits until the "Sign In" button is clickable before clicking it.
     * </p>
     */
    public void signIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
    /**
     * Returns the "Remember Me" checkbox WebElement.
     *
     * @return the WebElement representing the "Remember Me" checkbox.
     */
    public WebElement getRememberCheckbox() {
        return rememberCheckbox;
    }
}
