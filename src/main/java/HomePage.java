import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By SIGN_IN_BUTTON = By.cssSelector("a[title='Log in to your customer account']");
    private static final By USER_NAME = By.cssSelector("a[title='View my customer account'] > span");
    private static final By SIGN_OUT_BUTTON = By.cssSelector("a[title='Log me out']");
    private static final String URL = "http://automationpractice.com/index.php";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() {
        clickElement(SIGN_IN_BUTTON);
    }

    public HomePage navigateToHomePage() {
        navigateTo(URL);
        return this;
    }

    public boolean isEmailPageOpen(String username) {
        return driver.findElement(USER_NAME).getText().contains(username);
    }

    public void clickOnSignOutButton() {
        clickElement(SIGN_OUT_BUTTON);
    }


}
