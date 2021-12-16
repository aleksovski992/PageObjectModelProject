package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    By dayOfBirth = By.id("days");
    By monthOfBirth = By.id("months");
    By yearOfBirth = By.id("years");
    By stateSelectBtn = By.id("id_state");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTitleRadioBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleMrBtn)).click();
    }

    public void inputFirstName(String name) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameBtn)).sendKeys(name);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameBtn).sendKeys(lastName);
    }

    public void inputPassword(String pass) {
        driver.findElement(passwordBtn).sendKeys(pass);
    }

    public void selectBirthDay(int index) {
        Select days = new Select(driver.findElement(dayOfBirth));
        days.selectByIndex(index);
    }

    public void selectBirthMonth(int index) {
        Select birthMonth = new Select(driver.findElement(monthOfBirth));
        birthMonth.selectByValue(String.valueOf(index));
    }

    public void selectBirthYear(int index) {
        Select birthYear = new Select(driver.findElement(yearOfBirth));
        birthYear.selectByValue(String.valueOf(index));
    }

    public void inputCompanyName(String nameOfCompany) {
        driver.findElement(companyName).sendKeys(nameOfCompany);
    }

    public void inputCompanyAddress(String addressOfCompany) {
        driver.findElement(companyAddress).sendKeys(addressOfCompany);
    }

    public void inputCity(String cityOfLiving) {
        driver.findElement(city).sendKeys(cityOfLiving);
    }

    public void selectState(int index) {
        Select state = new Select(driver.findElement(stateSelectBtn));
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