package Tests;
import Pages.AuthenticationPage;
import Pages.CreateAccountPage;
import Pages.MyAccountPage;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createAccount() {
        homePage.clickSignInButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailCredentials();
        authenticationPage.clickOnCreateAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
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

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyUserIsLogged();
    }
}