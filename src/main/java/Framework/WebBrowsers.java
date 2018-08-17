package Framework;


import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by casab on 11/2/2017.
 */
public class WebBrowsers {
    public static WebDriver getDriver(Browsers browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/gekodriver.exe");
                driver = new FirefoxDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException("Unknown browser: " + browserName);
        }
        return driver;
    }
}