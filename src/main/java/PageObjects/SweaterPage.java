package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SweaterPage {

    private WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSize(String size) {
        Select sizeDropDownInput = new Select(driver.findElement(By.name("group[1]")));
        sizeDropDownInput.selectByVisibleText(size);
    }

    public void chooseQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.click();
        quantityInput.clear();
        String quantityString = String.valueOf(quantity);
        quantityInput.sendKeys(quantityString);
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart"));
        addToCartButton.click();
    }

    public void goToCheckout() {
        WebElement goToCheckoutButton = driver.findElement(By.xpath("//*[text() = \"Proceed to checkout\"]"));
        goToCheckoutButton.click();
    }

}
