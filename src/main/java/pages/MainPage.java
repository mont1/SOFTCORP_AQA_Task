package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[contains(@class,'searchInput')]")
    private WebElement searchInput;

    @Step("Enter value '{value}' in search input.")
    public MainPage enterSearch(String value) {
        $(searchInput).setValue(value);
        return this;
    }

    @Step("Click search.")
    public ResultWindow clickSearch() {
        $(searchInput).pressEnter();
        return new ResultWindow();
    }
}
