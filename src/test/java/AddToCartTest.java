import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToCartTest extends BaseTest {
    private static final String EMAIL_ADDRESS = "ohap@abv.bg";
    private static final String PASSWORD = "Dieselron";
    HomePage homePage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    ProfilePage profilePage;
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
        profilePage = new ProfilePage(driver);
        womanClothesPage = new WomanClothesPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

    }

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