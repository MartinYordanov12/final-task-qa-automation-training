import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProfilePage extends BasePage {
    private static final By CUSTOMER_FIRST_NAME = By.id("customer_firstname");
    private static final By CUSTOMER_LAST_NAME = By.id("customer_lastname");
    private static final By PASSWORD = By.id("passwd");
    private static final By ADDRESS = By.id("address1");
    private static final By CITY = By.id("city");
    private static final By STATE = By.id("id_state");
    private static final By POSTAL_CODE = By.id("postcode");
    private static final By COUNTRY = By.id("id_country");
    private static final By MOBILE_PHONE = By.id("phone_mobile");
    private static final By REGISTER_BUTTON = By.id("//button[@id='submitAccount']/span");
    Select selectState = new Select(driver.findElement(STATE));
    Select selectCountry = new Select(driver.findElement(COUNTRY));

    public CreateProfilePage(WebDriver driver) {
        super(driver);
    }

    public void createProfile(String userName, String lastName, String password, String address, String city, String value, int zipCode, String country, int mobileNumber) {
        fillField(CUSTOMER_FIRST_NAME, userName);
        fillField(CUSTOMER_LAST_NAME, lastName);
        fillField(PASSWORD, password);
        fillField(ADDRESS, address);
        fillField(CITY, city);
        clickElement(STATE);
        selectState.selectByValue(value);
        fillFieldWithNumber(POSTAL_CODE, zipCode);
        clickElement(COUNTRY);
        selectCountry.selectByValue(country);
        fillFieldWithNumber(MOBILE_PHONE, mobileNumber);
        clickElement(REGISTER_BUTTON);
    }
}
