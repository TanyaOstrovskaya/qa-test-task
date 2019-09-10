import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ResendPage;
import pages.ResendVdPage;
import steps.FirstPageSteps;
import steps.ResendPageSteps;
import steps.ResendVdPageSteps;
import utils.Util;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private final String firstPageUrl = "https://www.wrike.com";

    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Util.MAX_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    }

    @Test
    public void testAccountCreationThenQuestionsSubmissionThenTwitterButtonWork(){
        driver.get(firstPageUrl);

        // ASSERT 1: check if moved to the next page
        var firstPageSteps = new FirstPageSteps(driver);
        firstPageSteps.createWrikeAccount(Util.generateRandomWrikeTestEmail());
        var url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains(ResendVdPage.PAGE_URL_SUBSTRING) || url.contains(ResendPage.PAGE_URL_SUBSTRING));

        // ASSERT 2: answers submitted
        if (url.contains(ResendVdPage.PAGE_URL_SUBSTRING)) {
            var resendVdPageSteps = new ResendVdPageSteps(driver);
            var isQuestionSubmitSuccessful = resendVdPageSteps.answerWrikeUsageQuestions();
            Assert.assertTrue(isQuestionSubmitSuccessful);
            Assert.assertTrue(resendVdPageSteps.checkTwitterIconLinkAndIconCorrectness());
        } else if (url.contains(ResendPage.PAGE_URL_SUBSTRING)) {
            var resendPageSteps = new ResendPageSteps(driver);
            var isQuestionSubmitSuccessful = resendPageSteps.answerWrikeUsageQuestions();
            Assert.assertTrue(isQuestionSubmitSuccessful);
        } else {
            Assert.fail("Url is not /resend or /resend-v* after wrike account creation");
        }




        // ASSERT 3: Twitter button is correct
        // Create results report
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
