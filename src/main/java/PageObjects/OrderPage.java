package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmAddress() {
        WebElement addressContinue = driver.findElement(By.name("confirm-addresses"));
        addressContinue.click();
    }

    public void chooseDeliveryMetod() {
        WebElement deliveryOption = driver.findElement(By.xpath("//*[text() = \"PrestaShop\"]"));

        try {
            deliveryOption.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Opcja dostawy jest juz zaznaczona");
        }

        WebElement confirmDeliveryOptionButton = driver.findElement(By.name("confirmDeliveryOption"));
        confirmDeliveryOptionButton.click();
    }

    public void choosePaymentMethod() {
        WebElement paymentMethodOption = driver.findElement(By.xpath("//*[text() = \"Pay by Check\"]"));

        try {
            paymentMethodOption.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Opcja platnosci jest juz zaznaczona");
        }
    }

    public void clickOrderWithAnObligationToPayButton() {
        WebElement aggreTermsInput = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        aggreTermsInput.click();

        WebElement orderWithAnObligationToPayButton = driver.findElement(By.cssSelector("button.btn-primary.center-block"));
        orderWithAnObligationToPayButton.click();
    }
}
