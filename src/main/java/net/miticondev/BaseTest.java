package net.miticondev;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.miticondev.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    public static WebDriver getDriver(String url) {

        WebDriver driver = null;
        String browser = ConfigProperties.getBrowser();

        String chromeBrowser = "chrome";
        String firefoxBrowser = "firefox";

        if (browser.equalsIgnoreCase(chromeBrowser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(firefoxBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Error");
        }
        assert driver != null;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
