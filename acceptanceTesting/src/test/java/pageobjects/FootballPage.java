package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FootballPage extends BaseClass{

    public FootballPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Competitions")
    public static WebElement competitionsLink;
}
