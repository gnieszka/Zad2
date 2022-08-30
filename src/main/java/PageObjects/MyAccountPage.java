package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddressPage(){
        WebElement addressButton = null;
        try {
            addressButton = driver.findElement(By.id("address-link"));
        } catch (NoSuchElementException e) {
            addressButton = driver.findElement(By.id("addresses-link"));
        }

        addressButton.click();
    }

}
