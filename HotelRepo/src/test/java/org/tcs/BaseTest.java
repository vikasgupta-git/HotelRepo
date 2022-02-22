package org.tcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Executables\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        return driver;

    }
}
