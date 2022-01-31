package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ResultWindow extends BasePage {
    private static final String WINDOW_XPATH = "//div[contains(@class,'v-modal-search')]";
    @FindBy(xpath = WINDOW_XPATH)
    private WebElement resultWindow;
    @FindBy(xpath = WINDOW_XPATH + "//span")
    private WebElement eventsFoundCount;
    @FindBy(xpath = WINDOW_XPATH + "//input[@id='checkbox_1']")
    private WebElement liveCheckbox;
    @FindBy(xpath = WINDOW_XPATH + "//input[@id='checkbox_2']")
    private WebElement sportsCheckbox;
    @FindBy(xpath = WINDOW_XPATH + "//input[@id='search-in-popup']")
    private WebElement searchInput;
    @FindBy(xpath = WINDOW_XPATH + "//button[@class='search-popup__button']")
    private WebElement searchButton;
    @FindBy(xpath = WINDOW_XPATH + "//div[@class='search-popup__close']")
    private WebElement closeButton;
    @FindBy(xpath = WINDOW_XPATH + "//div[@class='search-popup__clear']")
    private WebElement clearButton;
    @FindBy(xpath = WINDOW_XPATH + "//button[contains(text(),'Matches')]")
    private WebElement matchesTab;
    @FindBy(xpath = WINDOW_XPATH + "//button[contains(text(),'Leagues')]")
    private WebElement leaguesTab;
    @FindBy(xpath = WINDOW_XPATH + "//div[contains(text(),'No results')]")
    private WebElement noResults;
    @Getter
    @FindBy(xpath = WINDOW_XPATH + "//div[@class='search-popup-events__item']")
    private List<WebElement> resultList;
    @Getter
    @FindBy(xpath = WINDOW_XPATH + "//div[@class='search-popup-event__teams']")
    private List<WebElement> teamsResultList;

    public ResultWindow() {
        $(resultWindow).shouldBe(Condition.visible);
    }

    public int getFoundEventsNumber() {
        return Integer.parseInt($(eventsFoundCount).getText());
    }

    public boolean isDisplayed() {
        log.info("Get displayed.");
        return $(resultWindow).isDisplayed();
    }

    @Step("Click live checkbox.")
    public ResultWindow clickLiveCheckbox() {
        $(liveCheckbox).click();
        log.info("Click live checkbox.");
        return new ResultWindow();
    }

    @Step("Click sports checkbox.")
    public ResultWindow clickSportsCheckbox() {
        $(sportsCheckbox).click();
        log.info("Click sports checkbox.");
        return this;
    }

    @Step("Enter value '{value}' in search input.")
    public ResultWindow enterSearchInput(String value) {
        $(searchInput).setValue(value);
        log.info("Enter value " + value + " in search input.");
        return this;
    }

    @Step("Click search button.")
    public ResultWindow clickSearchButton() {
        $(searchButton).click();
        log.info("Click search button.");
        return new ResultWindow();
    }

    @Step("Click close button.")
    public MainPage clickCloseButton() {
        $(closeButton).click();
        log.info("Click close button.");
        return new MainPage();
    }

    @Step("Click matches tab.")
    public ResultWindow clickMatchesTab() {
        $(matchesTab).shouldBe(Condition.visible).click();
        log.info("Click matches tab.");
        return this;
    }

    @Step("Click leagues tab.")
    public ResultWindow clickLeaguesTab() {
        $(leaguesTab).shouldBe(Condition.visible).click();
        log.info("Click leagues tab.");
        return this;
    }

    public boolean isNoResultsDisplay() {
        log.info("Get 'No result' displayed.");
        return $(noResults).isDisplayed();
    }

    @Step("Click clear button.")
    public ResultWindow clickClearButton() {
        $(clearButton).click();
        log.info("Click clear button.");
        return this;
    }

    public String getSearchInputValue() {
        return $(searchInput).getValue();
    }
}
