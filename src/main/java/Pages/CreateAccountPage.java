package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreateAccountPage {

    public WebDriver driver;
    public WebDriverWait wait;
    By titleMrBtn = By.id("uniform-id_gender1");
    By firstNameBtn = By.id("customer_firstname");
    By lastNameBtn = By.id("customer_lastname");
    By passwordBtn = By.id("passwd");
    By companyName = By.id("company");
    By companyAddress = By.id("address1");
    By city = By.id("city");
    By postCode = By.id("postcode");
    By mobilePhone = By.id("phone_mobile");
    By registerButton = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTitleRadioBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleMrBtn)).click();
    }

    public void inputFirstName() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameBtn)).sendKeys("Aleksandar");
        //driver.findElement(firstNameBtn).sendKeys("Aleksandar");
    }

    public void inputLastName() {
        driver.findElement(lastNameBtn).sendKeys("Aleksovski");
    }

    public void inputPassword() {
        driver.findElement(passwordBtn).sendKeys("AceAce!1234");
    }

    public void selectBirthDay(int index) {
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByIndex(index);
    }

    public void selectBirthMonth(int index) {
        Select birthMonth = new Select(driver.findElement(By.id("months")));
        birthMonth.selectByValue(String.valueOf(index));
    }

    public void selectBirthYear(int index) {
        Select birthYear = new Select(driver.findElement(By.id("years")));
        birthYear.selectByValue(String.valueOf(index));
    }

    public void inputCompanyName(String nameOfCompany) {
        driver.findElement(companyName).sendKeys(nameOfCompany);
    }

    public void inputCompanyAddress(String companyAdress) {
        driver.findElement(companyAddress).sendKeys(companyAdress);
    }

    public void inputCity(String cityOfLiving) {
        driver.findElement(city).sendKeys(cityOfLiving);
    }

    public void selectState(int index) {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue(String.valueOf(index));
    }

    public void inputPostCode(String index) {
        driver.findElement(postCode).sendKeys(index);
    }

    public void inputMobilePhone(String phoneNumber) {
        driver.findElement(mobilePhone).sendKeys(phoneNumber);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}