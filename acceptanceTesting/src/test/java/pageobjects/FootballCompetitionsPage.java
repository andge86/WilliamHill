package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FootballCompetitionsPage extends BaseClass{

    public FootballCompetitionsPage(WebDriver driver) {
        super(driver);
    }

// Methods related to certain page are included in PlaceBet class.
// Good idea is to include them into each page class as per POM practices.
// There is a point to add additional class for betslip "page"

    @FindBy(how = How.XPATH, using = "//li[contains(@data-toggle-receive, 'Popular-Competitions')]/ul/li[1]")
    public static WebElement firstCompetition;

    @FindBy(how = How.LINK_TEXT, using = "English Premier League")
    public static WebElement englishPremierLeagueCompetition;

    @FindBy(how = How.XPATH, using = "//div[@class = 'market-group marketW win-draw-win events-group-container']//div[@class ='btmarket__selection']//span[@class = 'betbutton__odds']")
    public static WebElement odds;

    // WebElement used only for mobile emulation testing
    @FindBy(how = How.XPATH, using = "//div[@id = 'betslip-btn-toolbar']")
    public static WebElement betslipIcon;

    // Input field for placing a bet
    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'betslip-selection__stake-input')]")
    public static WebElement betslip;

    // Calculated by system return value
    @FindBy(how = How.ID, using = "total-to-return-price")
    public static WebElement toReturn;


}
