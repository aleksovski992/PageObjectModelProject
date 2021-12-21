package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
    By myAccountPageHeading = By.className("page-heading");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyUserIsLogged() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountPageHeading)).getText();
        Assert.assertEquals("MY ACCOUNT", text);
    }
}