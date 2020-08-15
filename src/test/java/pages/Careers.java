package pages;

import helper.HelperMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Careers {
    private static final Logger logger = Logger.getLogger(Careers.class.getName());

    public static void checkCountOfCareers() {
        String countOfCareers = HelperMethods.findElementByXpath("//span[@class='job-count']").getText();
        HelperMethods.clickElementByXpath("//a[@href='https://sflpro.com/job/']");
        List<WebElement> openVacancies = HelperMethods.findElementsByXpath("//li[@class='smartrecruitersJobListElement']");
        String countOfOpenVacancies = String.valueOf(openVacancies.size());
        Assert.assertEquals(countOfCareers, countOfOpenVacancies);
    }

    public static void checkManualQAPosition() {
        List<WebElement> jobs = HelperMethods.findElementsByXpath("//span[@class='s-careers-title']");
        List<String> jobTitles = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            jobTitles.add(jobs.get(i).getText());
        }
        Assert.assertFalse(jobTitles.contains("Manual QA Engineer"));
    }

    public static void checkAutomationQAEngineerPosition() {
        try {
            HelperMethods.clickElementByXpath("//span[contains(.,'QA Automation Engineer')]");
        } catch (Exception e) {
            logger.info("There is no vacancy for Automation QA Engineer!");
            assert (false);
        }
    }

    public static void scrollToSubmitButtonAndFillInForm() {
        WebElement element = HelperMethods.findElementByXpath("//div[@id='6174']//input[@value='Submit']");
        HelperMethods.scrollToElementVisible(element);
        HelperMethods.findAndSendKeysByXpath("//div[@id='6174']//input[@name='Firstname']", "Test");
        HelperMethods.findAndSendKeysByXpath("//div[@id='6174']//input[@name='Lastname']", "Test");
        HelperMethods.findAndSendKeysByXpath("//div[@id='6174']//input[@name='E-mailaddress']", "test@test.com");
        String path = System.getProperty("user.dir");
        System.out.println(path);
        String filepath = path + "\\src\\main\\resources\\CV.pdf";
        HelperMethods.findAndSendKeysByXpath("//div[@id='6174']//input[@name='file-441']", filepath);
        HelperMethods.clickElementByXpath("//div[@id='6174']//input[@value='Submit']");
    }
}
