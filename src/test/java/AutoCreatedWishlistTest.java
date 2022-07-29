import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoCreatedWishlistTest extends BaseTest {

    private static final String EMAIL_ADDRESS = "ohap@abv.bg";
    private static final String PASSWORD = "Dieselron";
    HomePage homePage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    ProfilePage profilePage;
    WomanClothesPage womanClothesPage;

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

    }

    //@RepeatedTest(4)
    @Test
    void AutoCreatedMyWishlist() {
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
