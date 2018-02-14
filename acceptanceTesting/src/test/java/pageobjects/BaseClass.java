package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BaseClass {

    public BaseClass(WebDriver driver){
        this.driver = driver;

    }


    public WebDriver driver;


// Logging in WebElements are placed here because they are the same for all pages
// Methods related to certain page are included in PlaceBet class.
// Good idea is to include them into each page class as per POM practices.

    @FindBy(how = How.ID, using = "accountTabButton")
    public static WebElement accountButton;

    @FindBy(how = How.ID, using = "loginUsernameInput")
    public static WebElement loginField;

    @FindBy(how = How.ID, using = "loginPasswordInput")
    public static WebElement passwordField;

    @FindBy(how = How.ID, using = "loginButton")
    public static WebElement loginButton;

    @FindBy(how = How.CLASS_NAME, using = "icon-accountLI")
    public static WebElement loggedInUserIcon;

    @FindBy(how = How.ID, using = "details_name")
    public static WebElement loggedInUserName;



}
