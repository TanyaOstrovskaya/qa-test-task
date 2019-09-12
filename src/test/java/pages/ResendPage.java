package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

public class ResendPage extends PageObjectPrototype{
    public static final String PAGE_URL_SUBSTRING = "https://www.wrike.com/resend";

    // Question 1
    @FindBy(xpath = "(//button)[5]")
    private WebElement question1Option1;
    @FindBy(xpath = "(//button)[6]")
    private WebElement question1Option2;

    // Question 2
    @FindBy(xpath = "(//button)[7]")
    private WebElement question2Option1;
    @FindBy(xpath = "(//button)[8]")
    private WebElement question2Option2;
    @FindBy(xpath = "(//button)[9]")
    private WebElement question2Option3;
    @FindBy(xpath = "(//button)[10]")
    private WebElement question2Option4;
    @FindBy(xpath = "(//button)[11]")
    private WebElement question2Option5;

    // Question 3
    @FindBy(xpath = "(//button)[12]")
    private WebElement question3Option1;
    @FindBy(xpath = "(//button)[13]")
    private WebElement question3Option2;
    @FindBy(xpath = "(//button)[14]")
    private WebElement question3Option3;
    @FindBy(xpath = "(//button)[14]/*[1]/*[1]")
    private WebElement question3InputCommentField;
    @FindBy(xpath = "(//button)[15]")
    private WebElement submitResultButton;

    @FindBy(xpath = "(//div[@class='survey-success'])[1]")
    private WebElement submitSuccessBlock;

    @FindBy(xpath = "//div[@class='wg-footer__bottom-section']/descendant::a[1]")
    private WebElement twitterLink;
    @FindBy(xpath = "//div[@class='wg-footer__bottom-section']/descendant::*[name()='svg'][1]/child::*[1]")
    private WebElement twitterIcon;



    private WebDriverWait wait;

    public ResendPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Util.MAX_WAIT_IN_SECONDS);
    }

    public void selectRandomFirstQuestionOption(){
        var option = Util.TwoQuestionOptions.getRandomOption();
        switch (option){
            case Option1:
                question1Option1.click();
                break;
            case Option2:
                question1Option2.click();
                break;
            default:
                break;
        }
    }

    public void selectRandomSecondQuestionOption(){
        var option = Util.FiveQuestionOptions.getRandomOption();
        switch (option){
            case Option1:
                question2Option1.click();
                break;
            case Option2:
                question2Option2.click();
                break;
            case Option3:
                question2Option3.click();
                break;
            case Option4:
                question2Option4.click();
                break;
            case Option5:
                question2Option5.click();
                break;
            default:
                break;
        }
    }

    public void selectRandomThirdQuestionOption(){
        var option = Util.ThreeQuestionOptions.getRandomOption();
        switch (option){
            case Option1:
                question3Option1.click();
                break;
            case Option2:
                question3Option2.click();
                break;
            case Option3:
                question3Option3.click();
                question3InputCommentField.sendKeys("test");
                break;
        }
        submitResultButton.click();
    }

    public void waitUntilSubmitSuccessfulBlockVisible(){
        wait.until(ExpectedConditions.visibilityOf(submitSuccessBlock));
    }

    public boolean isSubmitQuestionSuccessful(){
        return submitSuccessBlock.isDisplayed();
    }

    public boolean checkTwitterIconCorrect(){
        return twitterIcon.isDisplayed() &&
                twitterIcon.getAttribute("xlink:href").equalsIgnoreCase(Util.TWITTER_ICON_CONTENT_HREF);
    }

    public boolean checkTwitterLinkCorrect(){
        return twitterLink.isEnabled() &&
                twitterLink.getAttribute("href").equalsIgnoreCase(Util.TWITTER_WRIKE_LINK);
    }
}
