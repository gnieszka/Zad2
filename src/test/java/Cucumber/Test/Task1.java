package Cucumber.Test;

import PageObjects.AddressPage;
import PageObjects.HomePage;
import PageObjects.LogInPage;
import PageObjects.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task1 {

    private static WebDriver driver;
    private static String email = "ooo@o2.pl";
    private static String password = "jaktalala";

    @Given("Uzytkownik jest zalogowany")
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

    @When("Uzytkownik wchodzi w strone z adresami")
    public void goToAddressPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAddressPage();
    }

    @And("Dodada nowy adres z danymi: {string}, {string}, {string}, {string}, {string}, {string}")
    public void addNewAddress(String alias,String address,String city,String postCode,String country,String phone) {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.addNewAddress(alias, address, city, postCode, country, phone);
    }

    @Then("Dane nowego adresu powinny byc zgodne z: {string}, {string}, {string}, {string}, {string}, {string}")
    public void checkAddress(String alias,String address,String city,String postCode,String country,String phone) {
        AddressPage addressPage = new AddressPage(driver);
        String user = "Agnieszka Niewolna";

        String addressFromSite = addressPage.getLastAddedAddress();
        String addressToCheck = alias + "\n" + user + "\n" + address + "\n" + city + "\n"
                + postCode + "\n" + country + "\n" + phone;

        if (addressFromSite.equals(addressToCheck)){
            System.out.println("Adres jest poprawny");
        } else {
            System.out.println("Adres jest bledny");
        }
    }

    @And("Zamknie przegladarke")
    public void closeBrowser() {
        driver.quit();
    }

}
