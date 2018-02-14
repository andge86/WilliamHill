package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class StartPage extends BaseClass {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "nav-football")
    public static WebElement footballLink;

}