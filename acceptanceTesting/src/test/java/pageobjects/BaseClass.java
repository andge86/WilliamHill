package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    public BaseClass(WebDriver driver){
        this.driver = driver;

    }


    public WebDriver driver;




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
