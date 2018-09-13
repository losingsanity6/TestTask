package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class Waiters {
    private static Logger Log = Logger.getLogger(Waiters.class.getName());

    public static void waitPageToLoad(WebDriver driver, int seconds) {
        try {
            Log.info("Start waiting");
            new WebDriverWait(driver, seconds).until(
                    (ExpectedCondition<Boolean>) d ->
                            ((JavascriptExecutor) d)
                                    .executeScript("return document.readyState")
                                    .equals("complete")
            );
            Log.info("Finish waiting");
        }
        catch (Throwable error) {
            Log.info("Exception in wait for loading page method!" + error.getMessage());
        }
    }

    public static WebElement waitVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    private static WebDriver getDriver() {
        WebDriver driver;
        return  driver;
    }
}
