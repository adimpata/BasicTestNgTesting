package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
/**
 * Test class for login functionality.
 * <p>
 * This class contains test methods to verify the login functionality, including entering credentials,
 * interacting with the "Remember Me" checkbox, and verifying successful authentication.
 * </p>
 */
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    /**
     * Additional setup for each test method.
     * <p>
     * This method initializes the {@link LoginPage} object before each test method.
     * </p>
     */
    @BeforeMethod
    public void additionalSetup() {
        loginPage = new LoginPage(driver);
    }

    /**
     * Provides test data for login tests.
     * <p>
     * This DataProvider supplies multiple sets of login data for testing with different browsers, environments,
     * usernames, passwords, and "Remember Me" checkbox states.
     * </p>
     *
     * @return an array of test data sets.
     */
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{{"firefox", "dev", "testUser", "testPass", true}, {"chrome", "dev", "testUser1", "testPass1", false}};
    }
    /**
     * Tests the login functionality.
     * <p>
     * This test method verifies the login functionality by entering credentials, setting the "Remember Me" checkbox,
     * and checking its state.
     * </p>
     *
     * @param username  the username to be entered.
     * @param password  the password to be entered.
     * @param rememberMe the state of the "Remember Me" checkbox.
     */
    @Test
    @Parameters({"username", "password", "rememberMe"})
    public void loginTest(String username, String password, boolean rememberMe) {
        loginPage.enterCredentials(username, password);
        loginPage.clickRememberCheckbox(rememberMe);
        boolean actualState = loginPage.getRememberCheckbox().isSelected();
        if (rememberMe) {
            Assert.assertTrue(actualState, "The 'Remember Me' checkbox should be checked but it is not.");
        } else {
            Assert.fail("Forcing failure because 'rememberMe' is set to false.");
        }
        loginPage.signIn();
    }
    /**
     * Tests the login functionality using provided data.
     * <p>
     * This test method uses the data provided by {@link #getLoginData()} to verify the login functionality
     * across different browsers and environments.
     * </p>
     *
     * @param browser     the browser to be used for the test.
     * @param environment the environment to be used for the test.
     * @param username    the username to be entered.
     * @param password    the password to be entered.
     * @param rememberMe  the state of the "Remember Me" checkbox.
     */
    @Test(dataProvider = "loginData")
    public void loginTest1(String browser, String environment, String username, String password, boolean rememberMe) {
        //Enter credentials and check the checkbox
        loginPage.enterCredentials(username, password);
        loginPage.clickRememberCheckbox(rememberMe);
        //Check the status of the "Remember Me" checkbox
        Assert.assertEquals(loginPage.getRememberCheckbox().isSelected(), rememberMe, "The 'Remember Me' checkbox should be checked but it is not.");
        //Press the "Sign In" button
        loginPage.signIn();
        //Check if authentication was successful
    }
}