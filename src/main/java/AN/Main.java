package AN;

import java.util.concurrent.TimeUnit;

import PageObjects.AddressPage;
import PageObjects.LogInPage;
import PageObjects.MyAccountPage;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.HomePage;

public class Main {

    private static ChromeDriver driver;
    private static String email = "ooo@o2.pl";
    private static String password = "jaktalala";

    //Do testowania
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        HomePage homePage = new HomePage(driver);
        homePage.goToLogInPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginAs(email, password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAddressPage();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.addNewAddress("aga1", "Pruszkowski", "Warszawa", "02-457", "United Kingdom", "698255651");
        System.out.println(addressPage.getLastAddedAddress());



    }

}
