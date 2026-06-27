package tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverClass extends WebDriverFactory{
    private static WebDriver driver = null;

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
