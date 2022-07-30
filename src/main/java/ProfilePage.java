import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

    private static final By WOMAN_BUTTON = By.xpath("a[title='Women']");


    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}