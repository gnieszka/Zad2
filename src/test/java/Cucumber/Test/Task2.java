package Cucumber.Test;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Task2 {

    private static WebDriver driver;
    private static String email = "ooo@o2.pl";
    private static String password = "jaktalala";

    @Given("Uzytkownik jest juz zalogowany")
    public void logInUser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        HomePage homePage = new HomePage(driver);
        homePage.goToLogInPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginAs(email, password);
    }

    @When("wybierze do zakupu Hummingbird Printed Sweater")
    public void chooseHummingbirdPrintedSweater(){
        HomePage homePage = new HomePage(driver);
        homePage.goBackToHomePage();
        homePage.chooseProduct("Hummingbird printed sweater");
    }

    @And("wybierze rozmiar {string}")
    public void chooseSize(String size) {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.chooseSize(size);
    }

    @And("wybierze {int} sztuk według parametru podanego w teście")
    public void chooseQuantity(int quantity) {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.chooseQuantity(quantity);
    }

    @And("doda produkt do koszyka")
    public void addToCart() {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.addToCart();
    }

    @And("przejdzie do opcji - checkout")
    public void goToCheckout() {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.goToCheckout();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
    }

    @And("potwierdzi address")
    public void confirmAddress() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.confirmAddress();
    }

    @And("wybierze metodę odbioru - PrestaShop pick up in store")
    public void chooseDeliveryMetod() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.chooseDeliveryMetod();
    }

    @And("wybierze opcję płatności - Pay by Check")
    public void choosePaymentMethod() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.choosePaymentMethod();
    }

    @And("kliknie na - order with an obligation to pay")
    public void clickOrderWithAnObligationToPayButton() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickOrderWithAnObligationToPayButton();
    }


    @Then("zrobi screenshot z potwierdzeniem zamówienia i kwotą")
    public void takeScreenshot() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenshot();
    }

    @And("Zamknie okno przegladarki")
    public void closeBrowser() {
        driver.quit();
    }

}
