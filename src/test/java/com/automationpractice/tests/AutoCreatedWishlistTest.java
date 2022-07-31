package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyWishlistPage;
import com.automationpractice.pages.WomanClothesPage;
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
@Epic("Autocreated wishlist test")
@Feature("Autocreated wishlist test")

public class AutoCreatedWishlistTest extends BaseTest {

    private static final String EMAIL_ADDRESS = "ohap@abv.bg";
    private static final String PASSWORD = "Dieselron";
    HomePage homePage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    WomanClothesPage womanClothesPage;

    @BeforeEach
    void login() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnSignInButton();
        myWishlistPage = new MyWishlistPage(driver);
        womanClothesPage = new WomanClothesPage(driver);
        Allure.addAttachment("Browser name", browserName);
        Allure.addAttachment("Browser version", browserVersion);
    }

    @Story("Add new product")
    @Description("System autocreated new wishlist")
    @AllureId("1")
    //@RepeatedTest(4)
    @Test
    void autoCreatedMyWishlist() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        homePage.clickOnMyWishList();
        myWishlistPage.deleteMyWishlistIfExist();
        myWishlistPage.clickOnWomanButton();
        womanClothesPage.waitForFadedShortSleeveThisrtsToBeVisible();
        womanClothesPage.getFadedShortSleeveTshirtsName();

        womanClothesPage.clickOnFadedShortSleeveTshirts();
        womanClothesPage.clickOnAddToWishlist();
        womanClothesPage.clickOnCloseButton();
        homePage.clickOnUserName();
        homePage.clickOnMyWishList();
        myWishlistPage.clickOnMyWishlistBox();
        myWishlistPage.getFadedShortSleeveTshirtNameFromMyWishlist();
        assertTrue(myWishlistPage.returnNameOfFadedShortSleeveTshirts().contains(womanClothesPage.returnNameOfFadedShortSleeveTshirts()));
    }
}