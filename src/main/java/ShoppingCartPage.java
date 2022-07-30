import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

    private static final By FADED_SHORT_TOTAL_PRICE = By.cssSelector("#total_product_price_1_1_724485");
    private static final By BLOUSE_TOTAL_PRICE = By.cssSelector("#total_product_price_2_7_724485");
    private static final By PRINTED_DRESS_TOTAL_PRICE = By.cssSelector("#total_product_price_3_13_724485");
    private static final By TOTAL_PRODUCTS = By.cssSelector("#total_product");
    double sumOfTotalPrice;
    double totalProducts;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public double getFadedShortTotalPrice(){
        String fadedTotalPriceString = driver.findElement(FADED_SHORT_TOTAL_PRICE).getText();
        return Double.parseDouble(fadedTotalPriceString.replaceAll("[$,]", ""));
    }

    public double getBlouseTotalPrice(){
        String blouseTotalPriceString = driver.findElement(BLOUSE_TOTAL_PRICE).getText();
        return  Double.parseDouble(blouseTotalPriceString.replaceAll("[$,]", ""));
    }

    public double getPrintedDress(){
        String printedDressString = driver.findElement(PRINTED_DRESS_TOTAL_PRICE).getText();
        return Double.parseDouble(printedDressString.replaceAll("[$,]", ""));
    }

    public double getSumOfTotalPrice(){
        return sumOfTotalPrice = getFadedShortTotalPrice() + getBlouseTotalPrice() + getPrintedDress();
    }

    public double getTotalProducts(){
        String totalProductsString = driver.findElement(TOTAL_PRODUCTS).getText();
        return totalProducts = Double.parseDouble(totalProductsString.replaceAll("[$,]",""));
    }



}
