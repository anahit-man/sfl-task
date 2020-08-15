package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverManager {
    public static WebDriver driver;

    @BeforeSuite
    public void driverManager() {

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);


        String url = "https://sflpro.com/";
        driver.get(url);
    }

    public static WebDriver getDriver() {
        String path = System.getProperty("user.dir");
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
        }
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
