package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;


public class HomePage extends BasePage {
    List<WebElement> listOfBestSellersElem;
    By signInButton = By.className("login");
    By popularElements = By.cssSelector("ul#homefeatured li");
    By bestsellersTab = By.className("blockbestsellers");
    By bestsellerElements = By.cssSelector("ul#blockbestsellers li");
    By addToCardBtn = By.linkText("Add to cart");
    By continueShoppingBtn = By.cssSelector("span[title='Continue shopping']");
    By proceedToCheckout = By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void verifyNumOfPopularElements() {
        List<WebElement> listOfPopularProducts = driver.findElements(popularElements);
        Assert.assertEquals(listOfPopularProducts.size(), 7, "The number of the elements is incorrect");
    }

    public void clickBestSellerTab() {
        driver.findElement(bestsellersTab).click();
    }

    public void verifyNumOfBestsellerElem() {
        listOfBestSellersElem = driver.findElements(bestsellerElements);
        Assert.assertEquals(listOfBestSellersElem.size(), 7, "The number of the elements is incorrect");
    }

    public void addProductsAndProceedToCheckOut(int numOfProducts) {
        listOfBestSellersElem = driver.findElements(bestsellerElements);

        for(int i=0;i<numOfProducts;i++) {
            //click on the i-th bestsellers element
            listOfBestSellersElem.get(i).click();
            //click on the ADD button
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCardBtn)).click();
            if(i<(numOfProducts-1))
                //click on Continue shopping
                wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn)).click();
            else
                //click on Proceed to checkout
                wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
        }
    }
}