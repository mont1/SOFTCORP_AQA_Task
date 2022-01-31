package webdriver;

import data.BrowserType;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DriverFactory {
    @Step("Setup driver.")
    public static void setupDriver(BrowserType type) {
        log.info("Setup driver configuration.");
        switch (type) {
            case CHROME:
                type.getConfig().setConfiguration();
        }
    }
}
