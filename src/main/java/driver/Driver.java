package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class Driver {
    private static WebDriver driver;

    private Driver() {}

    static String browser = System.getProperty("browser", Browser.CHROME.browserName());

    public static WebDriver getDriver(){
        if (driver==null){
            if (browser.equals(Browser.EDGE.browserName())) {
                return new EdgeDriver();
            } else if (browser.equals(Browser.FIREFOX.browserName())) {
                return new FirefoxDriver();
            } else if (browser.equals(Browser.SAFARI.browserName())) {
                return new SafariDriver();
            } else {
                return new ChromeDriver();
            }
        }
        return driver;
    }

}
