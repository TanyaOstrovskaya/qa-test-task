package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectPrototype {
    protected WebDriver driver;

    public PageObjectPrototype(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}