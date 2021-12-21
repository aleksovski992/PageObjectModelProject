package Tests;
import Pages.AuthenticationPage;
import Pages.ShoppingCartSummaryPage;
import org.testng.annotations.Test;

public class EndToEndOrderTest extends BaseTest {
    @Test
    public void orderProductsAndPay() {
        driver.get("http://automationpractice.com/index.php");

        homePage.verifyNumOfPopularElements();
        homePage.clickBestSellerTab();
        homePage.verifyNumOfBestsellerElem();
        homePage.addProductsAndProceedToCheckOut(3);

        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.clickProceedToCheckoutBtn();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
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