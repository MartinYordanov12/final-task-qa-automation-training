import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    }

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