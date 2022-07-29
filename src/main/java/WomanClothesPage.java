import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomanClothesPage extends BasePage{

    private static final By FADED_SHORT_SLEEVE_TSHIRTS = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
    private static final By ADD_TO_WISHLIST = By.cssSelector("#wishlist_button");
    private static final By CLOSE_BUTTON = By.cssSelector("a[title='Close']");
    private static final By PRODUCT_FRAME = By.cssSelector("#fancybox-frame1659110697382");
    private static String FADED_SHORT_SLEEVE_TSHIRTS_NAME = "";

    public WomanClothesPage(WebDriver driver) {
        super(driver);

    }

    public void clickOnFadedShortSleeveTshirts(){
        clickElement(FADED_SHORT_SLEEVE_TSHIRTS);
    }

    public String getFadedShortSleeveTshirtsName(){
        FADED_SHORT_SLEEVE_TSHIRTS_NAME = driver.findElement(FADED_SHORT_SLEEVE_TSHIRTS).getText();
        System.out.println(FADED_SHORT_SLEEVE_TSHIRTS_NAME);
        return FADED_SHORT_SLEEVE_TSHIRTS_NAME;

    }

    public void clickOnAddToWishlist(){
        clickElement(ADD_TO_WISHLIST);
    }

    public void clickOnCloseButton(){
        clickElement(CLOSE_BUTTON);
    }

    public void waitForFadedShortSleeveThisrtsToBeVisible(){
        waitForElementsToBeVisible(FADED_SHORT_SLEEVE_TSHIRTS);
    }

    public void switchToProductFrame(){
        this.driver.switchTo().frame((WebElement) PRODUCT_FRAME);
    }

    public String  returnNameOfFadedShortSleeveTshirts(){
        return FADED_SHORT_SLEEVE_TSHIRTS_NAME;
    }
}
