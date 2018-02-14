package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class StartPage extends BaseClass {

    public StartPage(WebDriver driver) {
        super(driver);
    }

// Methods related to certain page are included in PlaceBet class.
// Good idea is to include them into each page class as per POM practices.

    @FindBy(how = How.ID, using = "nav-football")
    public static WebElement footballLink;

}