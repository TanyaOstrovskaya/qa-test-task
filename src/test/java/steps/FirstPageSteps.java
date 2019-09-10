package steps;

import org.openqa.selenium.WebDriver;
import pages.FirstPage;

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
        firstPage.waitUntilResendPageIsCurrent();
    }
}
