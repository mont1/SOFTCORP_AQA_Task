package custom_assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomAssert {
    private static final By liveElementXpath = By.xpath("//div[contains(@class,'v-modal-search')]//span[@class='search-popup-event__live']");

    public static void assertLiveElementNotExists(WebElement actualElement) {
        boolean isLiveElementExists = actualElement
                .findElements(liveElementXpath)
                .isEmpty();
        Assert.assertTrue(isLiveElementExists, "Live element shouldn't be exists.");
    }
}
