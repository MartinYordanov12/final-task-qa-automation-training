import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomanClothesPage extends BasePage{

    private static final By FADED_SHORT_SLEEVE_TSHIRTS = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
    private static final By ADD_TO_WISHLIST = By.cssSelector("#wishlist_button");
    private static final By CLOSE_BUTTON = By.cssSelector("a[title='Close']");
    private static final By FADED_SHIRT_ADD_TO_CART_BUTTON = By.xpath("//div[@id='center_column']/ul/li[1]/div[@class='product-container']//a[@title='Add to cart']/span[.='Add to cart']");
    private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("span[title='Continue shopping'] > span");
    private static final By BLOUSE_ADD_TO_CART_BUTTON = By.xpath("//div[@id='center_column']/ul/li[2]/div[@class='product-container']//a[@title='Add to cart']/span[.='Add to cart']");
    private static final By BLOUSE = By.xpath("//div[@id='center_column']/ul/li[2]/div[@class='product-container']//h5/a[@title='Blouse']");
    private static final By PRINTED_DRESS_ADD_TO_CART_BUTTON = By.xpath("//div[@id='center_column']/ul/li[3]/div[@class='product-container']//a[@title='Add to cart']/span[.='Add to cart']");
    private static final By PRINTED_DRESS = By.xpath("//div[@id='center_column']/ul/li[3]/div[@class='product-container']//h5/a[@title='Printed Dress']");
    private static final By PROCEED_TO_CHECKOUT = By.cssSelector("a[title='Proceed to checkout'] > span");
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

    public String  returnNameOfFadedShortSleeveTshirts(){
        return FADED_SHORT_SLEEVE_TSHIRTS_NAME;
    }

    public void waitForFadedShirtsAddToCartButtonToBeVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(FADED_SHORT_SLEEVE_TSHIRTS);
        action.moveToElement(we).build().perform();
        waitForElementsToBeVisible(FADED_SHIRT_ADD_TO_CART_BUTTON);
    }

    public void clickOnFadedShirtsAddToCartButton(){
        clickElement(FADED_SHIRT_ADD_TO_CART_BUTTON);
    }

    public void clickOnFadedShirtsContinueShopping(){
        clickElement(CONTINUE_SHOPPING_BUTTON);
    }

    public void waitForBlouseAddToCartButtonToBeVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(BLOUSE);
        action.moveToElement(we).build().perform();
        waitForElementsToBeVisible(BLOUSE_ADD_TO_CART_BUTTON);
    }

    public void clickOnBlouseAddToCartButton(){
        clickElement(BLOUSE_ADD_TO_CART_BUTTON);
    }


    public void clickOnBlouseContinueShoppingButton(){
        clickElement(CONTINUE_SHOPPING_BUTTON);
    }

    public void waitForPrintedDressAddToCartButtonToBeVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(PRINTED_DRESS);
        action.moveToElement(we).build().perform();
        waitForElementsToBeVisible(PRINTED_DRESS_ADD_TO_CART_BUTTON);
    }

    public void clickOnPrintedDressAddToCartButton(){
        clickElement(PRINTED_DRESS_ADD_TO_CART_BUTTON);
    }

    public void clickOnPrintedDressContinueShoppingButton(){
        clickElement(CONTINUE_SHOPPING_BUTTON);
    }

    public void clickOnProceedToCheckout(){
        clickElement(PROCEED_TO_CHECKOUT);
    }
}
