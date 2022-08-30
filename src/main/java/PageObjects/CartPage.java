package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[text() = \"Proceed to checkout\"]"));
        proceedToCheckoutButton.click();
    }

}
