package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShoppingCartSummaryPage {
    public WebDriver driver;
    public WebDriverWait wait;
    By proceedToCheckoutBtn = By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order&step=1']");
    By proceedToCheckoutAddressTabBtn = By.cssSelector("button[name='processAddress']");
    By termsOfServiceCheckbox = By.id("uniform-cgv");
    By proceedToCheckoutShippingTabBtn = By.cssSelector("button[name='processCarrier']");
    By payByBankWireBtn = By.cssSelector("a[title='Pay by bank wire']");
    By iConfirmMyOrderBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    By yourOrderIsCompleteTxtElem = By.xpath("//*[text()='Your order on My Store is complete.']");

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProceedToCheckoutBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn)).click();
    }

    public void clickProceedToCheckoutAddressTabBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutAddressTabBtn)).click();
    }

    public void checkTermsOfServiceCheckbox() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfServiceCheckbox)).click();
    }

    public void clickProceedToCheckoutShippingTabBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutShippingTabBtn)).click();
    }

    public void clickPayByBankWire() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(payByBankWireBtn)).click();
    }

    public void clickOnIConfirmMyOrder() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iConfirmMyOrderBtn)).click();
    }

    public void verifyOrderIsCompleted() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourOrderIsCompleteTxtElem)).isDisplayed();
    }
}