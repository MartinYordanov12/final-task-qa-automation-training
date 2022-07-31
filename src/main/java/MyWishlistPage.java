import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyWishlistPage extends BasePage {

    private static final By MY_WISHLIST_BOX = By.cssSelector("td:nth-of-type(1) > a");
    private static final By DELETE_MY_WISHLIST_BOX = By.cssSelector(".icon-remove");
    private static final By FADED_SHORT_SLEEVE_TSHIRT = By.cssSelector("p#s_title");
    private static final By WOMAN_BUTTON = By.cssSelector("a[title='Women']");
    private static final By NEW_MY_WISHLIST_NAME = By.id("name");
    private static final By SAVE_BUTTON = By.cssSelector("button#submitWishlist > span");
    private static String FADED_SHORT_SLEEVE_TSHIRT_NAME = "";

    public MyWishlistPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyWishlistBox() {
        clickElement(MY_WISHLIST_BOX);
    }

    public String getFadedShortSleeveTshirtNameFromMyWishlist() {
            FADED_SHORT_SLEEVE_TSHIRT_NAME = driver.findElement(FADED_SHORT_SLEEVE_TSHIRT).getText();
            System.out.println(FADED_SHORT_SLEEVE_TSHIRT_NAME);
            return FADED_SHORT_SLEEVE_TSHIRT_NAME;
    }

    public void deleteMyWishlistIfExist() {
        List<WebElement> webElementList = driver.findElements(MY_WISHLIST_BOX);
        if (webElementList.size() != 0) {
            WebElement deleteButton = driver.findElement(DELETE_MY_WISHLIST_BOX);
            deleteButton.click();
            acceptAlert();
        } else {
            driver.findElement(WOMAN_BUTTON);
        }
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnWomanButton(){
        clickElement(WOMAN_BUTTON);
    }

    public String returnNameOfFadedShortSleeveTshirts(){
        return FADED_SHORT_SLEEVE_TSHIRT_NAME;
    }

    public void createNewMyWishlist(){
        fillField(NEW_MY_WISHLIST_NAME, "new wishlist");
        clickElement(SAVE_BUTTON);
    }
}