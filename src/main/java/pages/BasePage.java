package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(WebDriverRunner.getWebDriver(), this);
    }
}
