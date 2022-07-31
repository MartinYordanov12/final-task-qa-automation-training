package com.automationpractice.tests;

import com.automationpractice.pages.CreateProfilePage;
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
@Epic("CreateNewProfile test")
@Feature("CreateNewProfile test")

public class CreateNewProfileTest extends BaseTest {

    private static final String EMAIL_ADDRESS = "124@yandex.com";

    private static final String FIRST_NAME = "Martin";
    private static final String LAST_NAME = "Yordanov";
    private static final String PASSWORD = "Dieselron";
    private static final String ADDRESS = "Ivan Vazov 6";
    private static final String CITY = "Sofia";
    private static final String STATE = "1";
    private static final String POSTAL_CODE = "00000";
    private static final String COUNTRY = "21";
    private static final String MOBILE_PHONE = "1234567890";

    private HomePage homePage;
    private LoginPage loginPage;
    private CreateProfilePage createProfilePage;
    @BeforeEach
    void login() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnSignInButton();
        loginPage.startCreatingNewProfile(EMAIL_ADDRESS);
        createProfilePage = new CreateProfilePage(driver);
        Allure.addAttachment("Browser name", browserName);
        Allure.addAttachment("Browser version", browserVersion);
    }

    @Story("Create a new profile")
    @Description("User tries to create new profile")
    @AllureId("1")
    @Test
    void createNewProfile(){
        createProfilePage.createProfile(FIRST_NAME,LAST_NAME,PASSWORD,ADDRESS,CITY,STATE,POSTAL_CODE,COUNTRY,MOBILE_PHONE);
        assertTrue(createProfilePage.isProfileNamePresented());
    }
}