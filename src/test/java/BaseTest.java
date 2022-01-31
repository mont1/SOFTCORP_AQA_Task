import com.codeborne.selenide.WebDriverRunner;
import data.BrowserType;
import listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import webdriver.DriverFactory;

import static com.codeborne.selenide.Selenide.open;
import static data.CommonValues.OPPABET_URL;

@Listeners(TestListener.class)
public class BaseTest {
    @BeforeSuite
    public void setUpBrowser() {
        DriverFactory.setupDriver(BrowserType.CHROME);
    }

    @BeforeMethod
    public void setUpURL() {
        open(OPPABET_URL);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }
}
