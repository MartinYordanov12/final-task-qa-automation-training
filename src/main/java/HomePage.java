import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final By SIGN_IN_BUTTON = By.cssSelector("a[title='Log in to your customer account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton(){
        clickElement(SIGN_IN_BUTTON);
    }
}
