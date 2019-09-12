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
        Assert.assertTrue("URL is incorrect after wrike account creation",
                url.contains(ResendVdPage.PAGE_URL_SUBSTRING) || url.contains(ResendPage.PAGE_URL_SUBSTRING));

        // ASSERT 2, 3: answers submitted, twitter icon is correct
        if (url.contains(ResendVdPage.PAGE_URL_SUBSTRING)) {

            // For "https://www.wrike.com/resend-vd" page

            var steps = new ResendVdPageSteps(driver);
            var isQuestionSubmit = steps.answerWrikeUsageQuestions();
            var isTwitterCorrect = steps.checkTwitterIconLinkAndIconIsCorrect();
            Assert.assertTrue("Question submission is unsuccessful", isQuestionSubmit);
            Assert.assertTrue("Twitter icon or link is incorrect", isTwitterCorrect);
        } else if (url.contains(ResendPage.PAGE_URL_SUBSTRING)) {

            // For "https://www.wrike.com/resend" and "https://www.wrike.com/resend-vc" pages

            var steps = new ResendPageSteps(driver);
            var isQuestionSubmit = steps.answerWrikeUsageQuestions();
            var isTwitterCorrect =  steps.checkTwitterIconLinkAndIconIsCorrect();
            Assert.assertTrue("Question submission is unsuccessful", isQuestionSubmit);
            Assert.assertTrue("Twitter icon or link is incorrect", isTwitterCorrect);
        } else {

            Assert.fail("Url is not /resend or /resend-v* after wrike account creation");
        }
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
