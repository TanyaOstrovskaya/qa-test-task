package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstPage;
import utils.Util;

public class FirstPageSteps {
    private FirstPage firstPage;

    public FirstPageSteps(WebDriver driver){
        this.firstPage = new FirstPage(driver);
    }

    public void createWrikeAccount(String email){
        firstPage.clickGetStartedForFreeButton();
        firstPage.waitUntilStartFreeTrialFormOpened();
        firstPage.fillEmailInputField(email);
        firstPage.clickCreateMyWrikeAccountButton();
        firstPage.waitUntilVerifySignUpPageIsCurrent();
    }
}
