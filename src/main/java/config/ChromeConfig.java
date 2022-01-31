package config;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChromeConfig implements DriverConfig {
    private static final long IMPLICITLY_WAIT = 10000;
    private static final long PAGE_LOAD_TIMEOUT = 40000;
    private static final String CHROME_DRIVER_EXE_PATH = "src/main/resources/chromedriver.exe";
    private static final String CHROME_BROWSER_NAME = "chrome";

    @Override
    public void setConfiguration() {
        Configuration.browser = CHROME_BROWSER_NAME;
        Configuration.pageLoadTimeout = PAGE_LOAD_TIMEOUT;
        Configuration.timeout = IMPLICITLY_WAIT;
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_EXE_PATH);
        log.info(printConfiguration());
    }

    @Override
    public String printConfiguration() {
        return String.format("Setup browser:/n" +
                        "name=%s;/n" +
                        "page load timeout=%d;/n" +
                        "implicitly wait=%d;/n" +
                        "path=%s.",
                CHROME_BROWSER_NAME, PAGE_LOAD_TIMEOUT, IMPLICITLY_WAIT, CHROME_DRIVER_EXE_PATH);
    }
}
