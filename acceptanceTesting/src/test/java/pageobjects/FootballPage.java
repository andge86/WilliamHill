package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FootballPage extends BaseClass{

    public FootballPage(WebDriver driver) {
        super(driver);
    }

// Methods related to certain page are included in PlaceBet class.
// Good idea is to include them into each page class as per POM practices.

    @FindBy(how = How.LINK_TEXT, using = "Competitions")
    public static WebElement competitionsLink;
}
