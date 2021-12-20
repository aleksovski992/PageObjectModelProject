package Tests;
import Pages.*;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class BaseTest {

        public WebDriver driver;
        public WebDriverWait wait;
        public HomePage homePage;
        public AuthenticationPage authenticationPage;
        public CreateAccountPage createAccountPage;
        public MyAccountPage myAccountPage;
        public ShoppingCartSummaryPage shoppingCartSummaryPage;
        String validationText = "\n" +
                "The website is temporarily unable to service your request as it exceeded resource limit.\n" +
                "Please try again later.\n";

        @BeforeTest
        public void logger() {
            BasicConfigurator.configure();
        }

        @BeforeClass
        public void setUp() {
            String chromedriver = "webdriver.chrome.driver";
            String chromePath = "C:\\Chrome Drivers\\ChromeDriver 96.0.4664.45\\chromedriver.exe";
            System.setProperty(chromedriver, chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get("http://automationpractice.com/index.php");
            homePage = new HomePage(driver);
            authenticationPage = new AuthenticationPage(driver);
            createAccountPage = new CreateAccountPage(driver);
            myAccountPage = new MyAccountPage(driver);
            shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        }

        @BeforeMethod @AfterMethod
        public void checkIfResourceLimitIsReached() {
            List<WebElement> list = driver.findElements(By.xpath("//*[text()='" + validationText + "']"));
            if(list.size()>0) {
                System.out.println("Error: Resource limit is reached");
                driver.close();
            }
        }

        @AfterClass
        public void closeBrowser(){
            driver.quit();
        }
    }