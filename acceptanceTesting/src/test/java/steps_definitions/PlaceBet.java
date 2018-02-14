package steps_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.decimal4j.util.DoubleRounder;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BaseClass;
import pageobjects.FootballCompetitionsPage;
import pageobjects.FootballPage;
import pageobjects.StartPage;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static helpers.waiters.*;



public class PlaceBet {

    public WebDriver driver;
    public WebDriverWait wait;

// Quick approach to use such variables to pass info from one method to another
    String odds;
    String betGiven;
    String deviceGiven;


    @Before
    public void startBrowser() {

        // Choosing ChromeDriver for your OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")){
        System.setProperty("webdriver.chrome.driver", "chromedriver");}
        else {System.setProperty("webdriver.chrome.driver", "chromedriver.exe");}
        }

    @Given("^I open WilliamHill football Competitions betting page from \"([^\"]*)\"$")
    public void i_open_WilliamHill_football_English_Premier_League_betting_page(String device) throws InterruptedException {

        // Logic for running on DesKtop or from Mobile (using emulation)
       if (device.equals("desktop")) {
           driver = new ChromeDriver();
           driver.manage().deleteAllCookies();
           driver.manage().window().maximize();
           wait = new WebDriverWait(driver, 15);

           deviceGiven = device;
       }
       else if (device.equals("mobile")) {

           Map<String, String> mobileEmulation = new HashMap<String, String>();
           mobileEmulation.put("deviceName", "iPhone 7");
           ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
           driver = new ChromeDriver(chromeOptions);
           driver.manage().deleteAllCookies();
           driver.manage().window().maximize();
           wait = new WebDriverWait(driver, 15);

           deviceGiven = device;
       }

        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        driver.get("http://sports.williamhill.com/betting/en-gb");
        waitAndClick(startPage.footballLink, wait);
        FootballPage footballPage = PageFactory.initElements(driver, FootballPage.class);
        waitAndClick(footballPage.competitionsLink, wait);
    }

    @Given("^I go to English Premier League events$")
    public void i_go_to_English_Premier_League_events() throws InterruptedException {
        FootballCompetitionsPage footballCompetitionsPage = PageFactory.initElements(driver, FootballCompetitionsPage.class);
        waitAndClick(footballCompetitionsPage.firstCompetition, wait);
        waitAndClick(footballCompetitionsPage.englishPremierLeagueCompetition, wait);
    }

    @Given("^I log in as user with login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_log_in_as_user_with_login_and_password(String login, String password) throws Exception{
        BaseClass baseClass = PageFactory.initElements(driver, BaseClass.class);
            waitAndClick(baseClass.accountButton, wait);
            waitAndEnterText(baseClass.loginField, login, wait);
            waitAndEnterText(baseClass.passwordField, password, wait);
            waitAndClick(baseClass.loginButton, wait);
            waitAndClick(baseClass.loggedInUserIcon, wait);

            Assert.assertEquals("Jacek", waitAndRetrieveText(baseClass.loggedInUserName, wait));

            waitAndClick(baseClass.loggedInUserIcon, wait);
        }

    @When("^I place a bet \"([^\"]*)\" for home team to 'Win'$")
    public void i_place_a_bet_for_home_team_to_Win(String bet) throws InterruptedException {
        FootballCompetitionsPage footballCompetitionsPage = PageFactory.initElements(driver, FootballCompetitionsPage.class);
        odds = waitAndRetrieveText(footballCompetitionsPage.odds, wait);
        waitAndClick(footballCompetitionsPage.odds, wait);

        if (deviceGiven.equals("mobile"))  // Fix to work on mobile emulation
        { waitAndClick(footballCompetitionsPage.betslipIcon, wait);}

        waitAndEnterText(footballCompetitionsPage.betslip, bet, wait);

        betGiven = bet;
    }

    @Then("^I will see returns based on bet and odds$")
    public void i_will_see_returns_based_on_bet_and_odds() throws InterruptedException {
        FootballCompetitionsPage footballCompetitionsPage = PageFactory.initElements(driver, FootballCompetitionsPage.class);
        String toReturn = waitAndRetrieveText(footballCompetitionsPage.toReturn, wait);

        // Logic to compare returns value calculated by system and manually calculated using bet and odds
        int num;
        int demon;

        if (odds.equals("EVS")) {
            num = 1;
            demon = 1;
        } else {
            String values[] = odds.split("/");
            num = Integer.parseInt(values[0]);
            demon = Integer.parseInt(values[1]);
        }

        double expected0 = Double.parseDouble(betGiven)*num/demon + Double.parseDouble(betGiven);
        double expected = DoubleRounder.round(expected0, 2, RoundingMode.DOWN);
        double actual = Double.parseDouble(toReturn);

        Assert.assertEquals(expected, actual, 0);

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}