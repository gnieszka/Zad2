package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLogInPage() {
        WebElement signInButton = driver.findElement(By.cssSelector("div.user-info"));
        signInButton.click();
    }

    //Aby wrocic do strony glownej z innej strony
    public void goBackToHomePage(){
        WebElement myStore = driver.findElement(By.id("_desktop_logo"));
        myStore.click();
    }

    public void chooseProduct(String product) {
        WebElement choosenProduct = driver.findElement(By.xpath("//*[text() = '" + product + "']"));
        choosenProduct.click();
    }
}
