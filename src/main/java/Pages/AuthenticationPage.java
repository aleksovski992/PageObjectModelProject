package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class AuthenticationPage {

    public WebDriver driver;
    By emailAddress = By.id("email_create");
    By createAccountButton = By.id("SubmitCreate");

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
        driver.findElement(emailAddress).sendKeys(getSaltString() + "@scalefocus.com");
    }

    public void clickOnCreateAccount() {
        driver.findElement(createAccountButton).click();
    }
}