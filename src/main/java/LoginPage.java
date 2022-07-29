import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By CREATE_USER_EMAIL_ADDRESS_FIELD = By.id("email_create");
    private static final By CREATE_AN_ACCOUNT_BUTTON = By.cssSelector("button#SubmitCreate > span");
    private static final By ALREADY_REGISTERED_EMAIL_ADDRESS_FIELD = By.id("email");
    private static final By ALREADY_REGISTERED_PASSWORD_FIELD = By.id("passwd");
    private static final By SIGN_IN_BUTTON = By.xpath("//button[@id='SubmitLogin']/span");
    private static final By AUTHENTICATION_FAILED_MESSAGE = By.cssSelector("div#center_column li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void startCreatingNewProfile(String email) {
        fillField(CREATE_USER_EMAIL_ADDRESS_FIELD, email);
        clickElement(CREATE_AN_ACCOUNT_BUTTON);
    }

    public void loginWithExistingProfile(String userName, String password) {
        fillField(ALREADY_REGISTERED_EMAIL_ADDRESS_FIELD, userName);
        fillField(ALREADY_REGISTERED_PASSWORD_FIELD, password);
        clickElement(SIGN_IN_BUTTON);
    }

    public boolean isLoginPageOpen() {
        try {
            driver.findElement(SIGN_IN_BUTTON);
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public boolean isAuthenticationFailedUserNameMessagePresent(){
        return driver.findElement(AUTHENTICATION_FAILED_MESSAGE).isDisplayed();
    }

    public boolean isAuthenticationFailedUserPasswordMessagePresent(){
        return driver.findElement(AUTHENTICATION_FAILED_MESSAGE).isDisplayed();
    }
}