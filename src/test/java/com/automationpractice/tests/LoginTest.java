package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestWatcherResult.class)
@Epic("Login Tests")
@Feature("Login and logout tests")

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

        Allure.addAttachment("Browser name", browserName);
        Allure.addAttachment("Browser version", browserVersion);
    }

    @Test
    @Story("User tries to login with valid credentials")
    @Description("Valid login Test with valid email and password")
    @AllureId("1")
    void loginTest() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        assertTrue(homePage.isEmailPageOpen(USER_NAME));
    }

    @Test
    @Story("User tries to logout")
    @Description("User click on logout button")
    @AllureId("2")
    void logoutTest() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        homePage.clickOnSignOutButton();
        assertTrue(loginPage.isLoginPageOpen());
    }

    @Test
    @Story("User tries to login with invalid credentials")
    @Description("Valid login Test with invalidvalid email and valid password")
    @AllureId("3")
    void loginTestWithInvalidEmail(){
        loginPage.loginWithExistingProfile(INVALID_EMAIL_ADDRESS, PASSWORD);
        assertTrue(loginPage.isAuthenticationFailedUserNameMessagePresent());
    }

    @Test
    @Story("User tries to login with invalid credentials")
    @Description("Valid login Test with valid email and invalid password")
    @AllureId("4")
    void loginTestWithInvalidPassword(){
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, INVALID_PASSWORD);
        assertTrue(loginPage.isAuthenticationFailedUserPasswordMessagePresent());
    }
}