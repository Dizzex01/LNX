package driverFactory;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {
    private static final String BROWSERTYPE = "browserType";

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        //String browserTypeName = System.getProperty(BROWSERTYPE);
        //String browserTypeName12 = System.getProperty("browserType12");

        String browserTypeName = "Chrome";

        switch (browserTypeName){
            case "Firefox":
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("61.0");
                return new RemoteWebDriver(
                        URI.create("http://13.93.39.91:4444/wd/hub").toURL(),
                        capabilities
                );
            case "Chrome":
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("69.0");
                return new RemoteWebDriver(
                        URI.create("http://13.93.39.91:4444/wd/hub").toURL(),
                        capabilities
                );

                default: throw new IllegalArgumentException(
                        "Parameter " + browserTypeName + " is not valid for browser types");
        }
    }
}
