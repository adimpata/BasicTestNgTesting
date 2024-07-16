package config;
/**
 * Configuration class containing identifiers for various web elements.
 * <p>
 * This class stores the locators (IDs and XPaths) for web elements that are used in the test scripts.
 * </p>
 */
public class Config {
    public static final String USERNAME_FIELD_ID = "username";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String REMEMBER_CHECKBOX_XPATH = "//input[@type = 'checkbox']";
    public static final String SIGN_IN_BUTTON_XPATH = "//a[@id='log-in']";
}
