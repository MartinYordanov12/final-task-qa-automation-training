import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private static final String EMAIL_ADDRESS = "ohap@abv.bg";
    private static final String PASSWORD = "Dieselron";
    private static final String USER_NAME = "Martin Yordanov";
    private static final String INVALID_EMAIL_ADDRESS = "123@yandex.com";
    private static final String INVALID_PASSWORD = "Dieselron1";
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    void login() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnSignInButton();
    }

    @Test
    void loginTest() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        assertTrue(homePage.isEmailPageOpen(USER_NAME));
    }

    @Test
    void logoutTest() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        homePage.clickOnSignOutButton();
        assertTrue(loginPage.isLoginPageOpen());
    }

    @Test
    void loginTestWithInvalidEmail(){
        loginPage.loginWithExistingProfile(INVALID_EMAIL_ADDRESS, PASSWORD);
        assertTrue(loginPage.isAuthenticationFailedUserNameMessagePresent());
    }

    @Test
    void loginTestWithInvalidPassword(){
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, INVALID_PASSWORD);
        assertTrue(loginPage.isAuthenticationFailedUserPasswordMessagePresent());
    }
}