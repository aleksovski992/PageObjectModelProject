import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class EndToEndOrderTest extends BaseTest {
    @BeforeTest
    public void logger() {
        BasicConfigurator.configure();
    }

    @BeforeMethod
    public void checkIfResourceLimitIsReached() {
        List<WebElement> list = driver.findElements(By.xpath("//*[text()='The website is temporarily unable to service your request as it exceeded resource limit.']"));
        if(list.size()>0) {
            driver.close();
            System.out.println("GOT INSIDE THE IF IN THE BEFORE METHOD");
        }
    }

    @Test
    public void orderProductsAndPay() {
        driver.get("http://automationpractice.com/index.php");

        homePage.verifyNumOfPopularElements();
        homePage.clickBestSellerTab();
        homePage.verifyNumOfBestsellerElem();
        homePage.addProductsAndProceedToCheckOut(3);

        shoppingCartSummaryPage.clickProceedToCheckoutBtn();

        authenticationPage.inputEmailAddressLogin("aleksandar.aleksovski@scalefocus.com");
        authenticationPage.inputPasswordLogin("AceAce!1234");
        authenticationPage.clickSignInBtn();

        shoppingCartSummaryPage.clickProceedToCheckoutAddressTabBtn();
        shoppingCartSummaryPage.checkTermsOfServiceCheckbox();
        shoppingCartSummaryPage.clickProceedToCheckoutShippingTabBtn();
        shoppingCartSummaryPage.clickPayByBankWire();
        shoppingCartSummaryPage.clickOnIConfirmMyOrder();
        shoppingCartSummaryPage.verifyOrderIsCompleted();
    }
}