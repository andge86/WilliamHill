package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waiters {

    WebDriver driver;
    WebDriverWait wait;

    public waiters(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public static void waitAndClick(WebElement element, WebDriverWait wait) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Thread.sleep(1000);
    }
    public static void waitAndEnterText(WebElement element, String text, WebDriverWait wait) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        Thread.sleep(1000);
    }
    public static String waitAndRetrieveText(WebElement element, WebDriverWait wait) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        Thread.sleep(1000);
        return text;
    }

}
