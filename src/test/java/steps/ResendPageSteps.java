package steps;

import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class ResendPageSteps {
    private ResendPage resendPage;

    public ResendPageSteps(WebDriver driver) {
        this.resendPage = new ResendPage(driver);
    }

    public boolean answerWrikeUsageQuestions(){
        resendPage.selectRandomFirstQuestionOption();
        resendPage.selectRandomSecondQuestionOption();
        resendPage.selectRandomThirdQuestionOption();
        resendPage.waitUntilSubmitSuccessfulBlockVisible();
        return resendPage.isSubmitQuestionSuccessful();
    }

    public boolean checkTwitterIconLinkAndIconIsCorrect(){
        return resendPage.checkTwitterIconCorrect() && resendPage.checkTwitterLinkCorrect();
    }
}
