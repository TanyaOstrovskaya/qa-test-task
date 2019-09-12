package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

public class FirstPage extends PageObjectPrototype {

    @FindBy(xpath = "(//button)[3]")
    private WebElement getStartedForFreeButton;

    @FindBy(xpath = "(//button)[10]")
    private WebElement createMyWrikeAccountButton;

    @FindBy(xpath = "(//input)[8]")
    private WebElement enterEmailInput;

    @FindBy(xpath = "(//form)[5]")
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

    public void waitUntilResendPageIsCurrent(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(ResendPage.PAGE_URL_SUBSTRING),
                ExpectedConditions.urlContains(ResendVdPage.PAGE_URL_SUBSTRING)
        ));
    }
}
