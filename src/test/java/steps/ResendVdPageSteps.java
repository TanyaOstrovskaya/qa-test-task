package steps;

import org.openqa.selenium.WebDriver;
import pages.ResendVdPage;

public class ResendVdPageSteps {
    private ResendVdPage resendVdPage;

    public ResendVdPageSteps(WebDriver driver) {
        this.resendVdPage = new ResendVdPage(driver);
    }

    public boolean answerWrikeUsageQuestions(){
        resendVdPage.selectRandomFirstQuestionOption();
        resendVdPage.selectRandomSecondQuestionOption();
        resendVdPage.selectRandomThirdQuestionOption();
        resendVdPage.waitUntilSubmitSuccessfulBlockVisible();
        return resendVdPage.isSubmitQuestionSuccessful();
    }

    public boolean checkTwitterIconLinkAndIconIsCorrect(){
        return resendVdPage.checkTwitterIconCorrect() && resendVdPage.checkTwitterLinkCorrect();
    }
}
