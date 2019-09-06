import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.VerifySignUpPage;
import steps.FirstPageSteps;
import utils.Util;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private final String firstPageUrl = "https://www.wrike.com";

    private static FirefoxDriver driver;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Util.MIN_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    }

    @Test
    public void testAccountCreationAndQuestionsSubmissionAndTwitterButton(){ // TODO: rename this method
        driver.get(firstPageUrl);

        // ASSERT 1: check if moved to the next page
        var firstPageSteps = new FirstPageSteps(driver);
        firstPageSteps.createWrikeAccount(Util.generateRandomWrikeTestEmail());
        Assert.assertTrue(driver.getCurrentUrl().contains(VerifySignUpPage.pageFraction));

        // ASSERT 2: answers submitted
        // ASSERT 3: Twitter button is correct
        // Create results report
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
