package tests;

import org.testng.annotations.Test;

import driver.DriverManager;
import pages.Careers;

public class CareersTests extends DriverManager {
    @Test(priority = 1)
    public void checkCountOfCareers() {
        Careers.checkCountOfCareers();
    }

    @Test(priority = 2)
    public void checkManualQAPosition() {
        Careers.checkManualQAPosition();
    }

    @Test(priority = 3)
    public void checkAutomationQAEngineerPosition() {
        Careers.checkAutomationQAEngineerPosition();
    }

    @Test(priority = 4)
    public void scrollToSubmitButtonAndFillInForm() {
        Careers.scrollToSubmitButtonAndFillInForm();
    }
}
