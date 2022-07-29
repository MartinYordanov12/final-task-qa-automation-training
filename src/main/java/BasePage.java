import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    void clickElement(By element) {
        driver.findElement(element).click();
    }

    void fillField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    void waitForElementsToBeVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}