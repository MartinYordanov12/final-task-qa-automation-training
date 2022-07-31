package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyWishlistPage;
import com.automationpractice.pages.ShoppingCartPage;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestWatcherResult.class)
@Epic("Add products to cart")
@Feature("Add products to cart")

public class AddToCartTest extends BaseTest {
    private static final String EMAIL_ADDRESS = "ohap@abv.bg";
    private static final String PASSWORD = "Dieselron";
    HomePage homePage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    WomanClothesPage womanClothesPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeEach
    void login() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnSignInButton();
        myWishlistPage = new MyWishlistPage(driver);
        womanClothesPage = new WomanClothesPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        Allure.addAttachment("Browser name", browserName);
        Allure.addAttachment("Browser version", browserVersion);
    }

    @Story("Add new products to cart")
    @Description("Compare the amount of added products with Total price")
    @AllureId("1")
    @Test
    void addToCartTest() {
        loginPage.loginWithExistingProfile(EMAIL_ADDRESS, PASSWORD);
        homePage.clickOnMyWishList();
        myWishlistPage.deleteMyWishlistIfExist();
        myWishlistPage.clickOnWomanButton();
        womanClothesPage.waitForFadedShortSleeveThisrtsToBeVisible();
        womanClothesPage.waitForFadedShirtsAddToCartButtonToBeVisible();
        womanClothesPage.clickOnFadedShirtsAddToCartButton();
        womanClothesPage.clickOnFadedShirtsContinueShopping();
        womanClothesPage.waitForBlouseAddToCartButtonToBeVisible();
        womanClothesPage.clickOnBlouseAddToCartButton();
        womanClothesPage.clickOnBlouseContinueShoppingButton();
        womanClothesPage.waitForPrintedDressAddToCartButtonToBeVisible();
        womanClothesPage.clickOnPrintedDressAddToCartButton();
        womanClothesPage.clickOnProceedToCheckout();
        assertEquals(shoppingCartPage.getSumOfTotalPrice(), shoppingCartPage.getTotalProducts());
    }
}