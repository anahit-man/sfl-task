package helper;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HelperMethods {
    private static final WebDriver driver = DriverManager.driver;

    public static void findAndSendKeysByXpath(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void clickElementByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static List findElementsByXpath(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements;
    }

    public static void scrollToElementVisible(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
