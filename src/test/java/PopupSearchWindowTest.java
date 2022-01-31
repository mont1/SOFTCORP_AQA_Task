import custom_assert.CustomAssert;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.ResultWindow;

import java.util.List;

public class PopupSearchWindowTest extends BaseTest {
    @Test(description = "Check opening popup window.")
    public void openResultWindowTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterSearch("francisco");
        ResultWindow resultWindow = mainPage.clickSearch();

        Assert.assertTrue(resultWindow.isDisplayed(), "Result window doesn't display.");
        Assert.assertEquals(resultWindow.getSearchInputValue(), "francisco",
                "Search value don't equal expected.");
    }

    @Test(dependsOnMethods = "openResultWindowTest", description = "Check closing popup window.")
    public void closeResultWindowTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterSearch("francisco");
        ResultWindow resultWindow = mainPage.clickSearch();
        resultWindow.clickCloseButton();

        Assert.assertFalse(resultWindow.isDisplayed(), "Result window shouldn't be visible.");
    }

    @Test(dependsOnMethods = "openResultWindowTest", description = "Check items count in found events description.")
    public void resultCountTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterSearch("washington");
        ResultWindow resultWindow = mainPage.clickSearch();
        List<WebElement> webElementList = resultWindow.getResultList();

        Assert.assertEquals(webElementList.size(), resultWindow.getFoundEventsNumber(),
                "Events found count don't equal a count of items.");
    }

    @Test(dependsOnMethods = "openResultWindowTest", description = "Check looking for events.")
    public void searchValueTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterSearch("washington");
        ResultWindow resultWindow = mainPage.clickSearch();
        List<WebElement> webElementList = resultWindow.getTeamsResultList();

        SoftAssert softAssert = new SoftAssert();
        for (WebElement webElement : webElementList) {
            softAssert.assertTrue(webElement.getText().toLowerCase().contains("washington"));
        }
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "openResultWindowTest", description = "Check clear button work.")
    public void clearButtonTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterSearch("washington");
        ResultWindow resultWindow = mainPage.clickSearch();
        resultWindow.clickClearButton();

        Assert.assertEquals(resultWindow.getSearchInputValue(), StringUtils.EMPTY, "Clear button don't work.");
    }

    @Test(dependsOnMethods = "openResultWindowTest", description = "Check ")
    public void emptyValueSearchTest() {
        ResultWindow resultWindow = new MainPage().clickSearch();
        resultWindow.clickMatchesTab();

        Assert.assertTrue(resultWindow.isNoResultsDisplay(), "No result text should be visible.");

        resultWindow.enterSearchInput("washington")
                .clickSearchButton()
                .clickClearButton()
                .clickSearchButton()
                .clickMatchesTab();

        Assert.assertTrue(resultWindow.isNoResultsDisplay(), "No result text should be visible.");
    }

    @Test(dependsOnMethods = "openResultWindowTest")
    public void liveSortTest() {
        ResultWindow resultWindow = new MainPage().enterSearch("washington").clickSearch();
        resultWindow.clickLiveCheckbox();

        List<WebElement> webElementList = resultWindow.getResultList();
        for (WebElement webElement : webElementList) {
            CustomAssert.assertLiveElementNotExists(webElement);
        }
    }
}
