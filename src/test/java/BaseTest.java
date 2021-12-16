import Pages.AuthenticationPage;
import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

        public WebDriver driver;
        public WebDriverWait wait;
        private String chromedriver = "webdriver.chrome.driver";
        private String chromePath = "C:\\Chrome Drivers\\ChromeDriver 96.0.4664.45\\chromedriver.exe";
        public HomePage homePage;
        public AuthenticationPage authenticationPage;
        public CreateAccountPage createAccountPage;
        public MyAccountPage myAccountPage;

        @BeforeClass
        public void setUp() {
            System.setProperty(chromedriver, chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get("http://automationpractice.com/index.php");
            homePage = new HomePage(driver);
            authenticationPage = new AuthenticationPage(driver);
            createAccountPage = new CreateAccountPage(driver);
            myAccountPage = new MyAccountPage(driver);
        }

//        @AfterClass
//        public void tearDown(){
//            driver.quit();
//        }
    }