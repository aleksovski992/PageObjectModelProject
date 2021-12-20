package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class AuthenticationPage {

    public WebDriver driver;
    public WebDriverWait wait;
    By emailAddress = By.id("email_create");
    By createAccountButton = By.id("SubmitCreate");
    By emailAddressLoginTxtBox = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input");
    By passwordLoginTxtBox = By.cssSelector("input[data-validate='isPasswd']");
    By signInBtn = By.id("SubmitLogin");

    public String getSaltString() {
        String salchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * salchars.length());
            salt.append(salchars.charAt(index));
        }
        return salt.toString();
    }

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmailCredentials() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress)).sendKeys(getSaltString() + "@scalefocus.com");
    }

    public void clickOnCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void inputEmailAddressLogin(String email) {
        driver.findElement(emailAddressLoginTxtBox).sendKeys(email);
    }

    public void inputPasswordLogin(String email) {
        driver.findElement(passwordLoginTxtBox).sendKeys(email);
    }

    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }
}