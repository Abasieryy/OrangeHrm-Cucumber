package tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverClass extends WebDriverFactory{
    private static WebDriver driver = null;

    public static WebDriver getEdgeDriver() {
        if (driver == null) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--inprivate");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
