package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AddressPage {

    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewAddress(String alias,String address,String city,String postCode,String country,String phone) {

        try {
            WebElement createNewAddressButton = driver.findElement(By.xpath("//*[text() = \"Create new address\"]"));
            createNewAddressButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("To jest pierwszy adres");
        }

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement postCodeInput = driver.findElement(By.name("postcode"));
        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);

        Select countryDropDownInput = new Select(driver.findElement(By.name("id_country")));
        countryDropDownInput.selectByVisibleText(country);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.cssSelector("button.float-xs-right"));
        saveButton.click();
    }

    public String getLastAddedAddress() {
        String address;
        List<WebElement> addresses = driver.findElements(By.cssSelector("div.address-body"));
        address = addresses.get(addresses.size() - 1).getText();

        return address;
    }

}
