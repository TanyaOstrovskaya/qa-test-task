package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Util;

public class ResendVdPage extends PageObjectPrototype {
    public static final String  PAGE_URL_SUBSTRING = "https://www.wrike.com/resend-vd";

    // Question 1
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[1]")
    private WebElement question1Option1;
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[2]")
    private WebElement question1Option2;

    // Question 2
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[3]")
    private WebElement question2Option1;
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[4]")
    private WebElement question2Option2;
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[5]")
    private WebElement question2Option3;

    // Question 3
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[6]")
    private WebElement question3Option1;
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[7]")
    private WebElement question3Option2;
    @FindBy(xpath = "(//span[@class='survey-question-radio__container'])[8]")
    private WebElement question3Option3;
    @FindBy(xpath = "(//input)[15]")
    private WebElement question3CommentInputField;
    @FindBy(xpath = "(//button)[7]")
    private WebElement submitResultButton;

    @FindBy(xpath = "(//div[@class=\"resend-page-success\"])[1]")
    private WebElement submitSuccessBlock;

    @FindBy(xpath = "//div[@class='wg-footer__bottom-section']/descendant::a[1]")
    private WebElement twitterLink;
    @FindBy(xpath = "//div[@class='wg-footer__bottom-section']/descendant::*[name()='svg'][1]/child::*[1]")
    private WebElement twitterIcon;


    public ResendVdPage(WebDriver driver) {
        super(driver);
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
        var option = Util.ThreeQuestionOptions.getRandomOption();
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
                question3CommentInputField.sendKeys("test");
                break;
        }
        submitResultButton.click();
    }

    public boolean isSubmitQuestionSuccessful(){
        return submitSuccessBlock.isDisplayed();
    }

    public boolean checkTwitterIconCorrect(){
        return twitterLink.getAttribute("href").equalsIgnoreCase(Util.TWITTER_WRIKE_LINK);
    }

    public boolean checkTwitterLinkCorrect(){
        return twitterIcon.getAttribute("xlink:href").equalsIgnoreCase(Util.TWITTER_ICON_CONTENT_HREF);
    }
}
