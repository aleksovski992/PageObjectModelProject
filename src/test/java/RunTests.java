import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunTests extends BaseTest {

    @BeforeTest
    public void initialize() {
        BasicConfigurator.configure();
    }

    @Test
    public void clickingOnSignInButton() {
        homePage.clickSignInButton();

        authenticationPage.inputEmailCredentials();
        authenticationPage.clickOnCreateAccount();

        createAccountPage.clickOnTitleRadioBtn();
        createAccountPage.inputFirstName();
        createAccountPage.inputLastName();
        createAccountPage.inputPassword();
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
        myAccountPage.navigateToHomePage();

        homePage.verifyNumOfPopularElements();
        homePage.clickBestSellerTab();
        homePage.verifyNumOfBestsellerElem();
        homePage.addProductsAndProceedToCheckOut(3);
    }
}