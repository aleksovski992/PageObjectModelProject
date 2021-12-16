package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyAccountPage {

    public WebDriver driver;
    public WebDriverWait wait;
    By myAccountPageHeading = By.id("uniform-id_gender1");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsLogged() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountPageHeading)).getText();
        Assert.assertEquals("MY ACCOUNT", text);
    }

    public void navigateToHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }
}