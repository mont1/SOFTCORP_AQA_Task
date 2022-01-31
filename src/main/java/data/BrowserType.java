package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import config.ChromeConfig;
import config.DriverConfig;

@Getter
@AllArgsConstructor
public enum BrowserType {
    CHROME(new ChromeConfig());
    private DriverConfig config;
}
