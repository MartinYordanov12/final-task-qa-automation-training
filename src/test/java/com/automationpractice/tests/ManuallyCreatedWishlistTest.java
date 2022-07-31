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
@Epic("ManuallyCreatedWishlist test")
@Feature("ManuallyCreatedWishlist test")

public class ManuallyCreatedWishlistTest extends BaseTest{
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
    @Story("User tries to create new wishlist")
    @Description("Manually create new wishlist and add product")
    @AllureId("1")
    @Test
    void manuallyCreatedWishlistTest(){
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        homePage.clickOnMyWishList();
        myWishlistPage.deleteMyWishlistIfExist();
        myWishlistPage.createNewMyWishlist();
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