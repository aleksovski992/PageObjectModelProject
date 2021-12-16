import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

        public WebDriver driver;
        public WebDriverWait wait;
        public HomePage homePage;
        public AuthenticationPage authenticationPage;
        public CreateAccountPage createAccountPage;
        public MyAccountPage myAccountPage;
        public ShoppingCartSummaryPage shoppingCartSummaryPage;

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

        @AfterClass
        public void closeBrowser(){
            driver.quit();
        }
    }