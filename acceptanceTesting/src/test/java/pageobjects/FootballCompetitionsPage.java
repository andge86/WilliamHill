package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FootballCompetitionsPage extends BaseClass{

    public FootballCompetitionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@class = 'market-group marketW win-draw-win events-group-container']//div[@class ='btmarket__selection']//span[@class = 'betbutton__odds']")
    public static WebElement odds;

//    @FindBy(how = How.XPATH, using = "//li[@id = 'betslip-tab'] |")
//    public static WebElement betslipLink;

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'betslip-selection__stake-input')]")
    public static WebElement betslip;

    @FindBy(how = How.ID, using = "total-to-return-price")
    public static WebElement toReturn;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-toggle-receive, 'Popular-Competitions')]/ul/li[1]")
    public static WebElement firstCompetition;


    @FindBy(how = How.LINK_TEXT, using = "English Premier League")
    public static WebElement englishPremierLeagueCompetition;
}
