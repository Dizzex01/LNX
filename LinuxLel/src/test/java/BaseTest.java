import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BaseTest {

    @Test
    public void PassedTest() throws MalformedURLException {
        RemoteWebDriver driver = DriverFactory.getDriver();

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[contains(@value,'Google')]"));
    }

    @Test
    public void FailedTest() throws MalformedURLException{
        RemoteWebDriver driver = DriverFactory.getDriver();

        driver.get("http://www.bing.com");
        driver.findElement(By.xpath("//input[contains(@value,'Google')]"));
    }
}
