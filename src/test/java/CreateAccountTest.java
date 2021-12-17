import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class CreateAccountTest extends BaseTest {

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
    public void createAccount() {
        homePage.clickSignInButton();

        authenticationPage.inputEmailCredentials();
        authenticationPage.clickOnCreateAccount();

        createAccountPage.clickOnTitleRadioBtn();
        createAccountPage.inputFirstName("Aleksandar");
        createAccountPage.inputLastName("Aleksovski");
        createAccountPage.inputPassword("AceAce!1234");
        createAccountPage.selectBirthDay(6);
        createAccountPage.selectBirthMonth(6);
        createAccountPage.selectBirthYear(1992);
        createAccountPage.inputCompanyName("Scalefocus");
        createAccountPage.inputCompanyAddress("Максим Горки 13, Скопје 1000");
        createAccountPage.inputCity("Skopje");
        createAccountPage.selectState(1);
        createAccountPage.inputPostCode("10000");
        createAccountPage.inputMobilePhone("0038970123456");
        createAccountPage.clickRegister();

        myAccountPage.verifyUserIsLogged();
    }
}