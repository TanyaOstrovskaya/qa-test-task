package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

public class FirstPage extends PageObjectPrototype {

    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")    // TODO: try to make XPath simpler
    private WebElement getStartedForFreeButton;

    // @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button") // TODO: select which attribute is better
    @FindBy(xpath = "/html/body/div[4]/div/form/label[2]/button")
    private WebElement createMyWrikeAccountButton;

    // @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    @FindBy(xpath = "/html/body/div[4]/div/form/label[1]/input")
    private WebElement enterEmailInput;

    @FindBy(xpath = "/html/body/div[4]/div/form")
    private WebElement startFreeTrialForm;

    private WebDriverWait wait;


    public FirstPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Util.MAX_WAIT_IN_SECONDS);
    }

    public void clickGetStartedForFreeButton() {
        getStartedForFreeButton.click();
    }

    public void fillEmailInputField(String email) {
        enterEmailInput.sendKeys(email);
    }

    public void clickCreateMyWrikeAccountButton(){
        createMyWrikeAccountButton.click();
    }

    public void waitUntilStartFreeTrialFormOpened(){
        wait.until(ExpectedConditions.visibilityOf(startFreeTrialForm));
    }

    public void waitUntilVerifySignUpPageIsCurrent(){
        wait.until(ExpectedConditions.urlContains(VerifySignUpPage.pageFraction));
    }
}
