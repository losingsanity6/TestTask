package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static tools.Waiters.waitPageToLoad;
import static tools.Waiters.waitVisibility;

public class MainPageHeaderLinks {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[contains(text(),'RIA.com')]")
    private WebElement riaCom;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[3]")
    private WebElement nedvizhemost;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[4]")
    private WebElement autotovary;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[5]")
    private WebElement autozapchastiny;

    @FindBy(xpath = "//div[@class='container']//span[contains(@class,'middle')]/input")
    private WebElement elementOnRiaCom;

    @FindBy(id = "mainSearchForm")
    private WebElement elementOnNeruhomist;

    @FindBy(xpath = "//div[@class='container']//div[@class='wrapper']")
    private WebElement elementOnAutotovary;

    @FindBy(xpath = "//div[@class='wrapping']//form[@class='search-main']")
    private WebElement elementOnAutozapchastiny;



    public MainPageHeaderLinks(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String getTitle() {
        String actualTitle = driver.getTitle();

        return actualTitle;
    }

    private String getUrl() {
        String currentUrl = driver.getCurrentUrl();

        return currentUrl;
    }

    public boolean checkOpenLinkRiaCom(String linkName, String expectedTitle, String expectedUrl) {
        String parentHandle = driver.getWindowHandle();
        waitVisibility(riaCom).click();
        waitPageToLoad(driver, 10);
        for (String winHandle : driver.getWindowHandles()) {
            waitPageToLoad(driver, 10);
            driver.switchTo().window(winHandle);
            waitPageToLoad(driver, 10);
        }
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(getTitle()) && expectedUrl.equalsIgnoreCase(getUrl()) && elementOnRiaCom.isDisplayed());
        driver.close();
        driver.switchTo().window(parentHandle);
        return true;
    }

    public boolean checkOpenLinkNeruhomist(String linkName, String expectedTitle, String expectedUrl) {
        String parentHandle = driver.getWindowHandle();
        nedvizhemost.click();
        waitPageToLoad(driver, 10);
        for (String winHandle : driver.getWindowHandles()) {
            waitPageToLoad(driver, 10);
            driver.switchTo().window(winHandle);
            waitPageToLoad(driver, 10);
        }
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(getTitle()) && expectedUrl.equalsIgnoreCase(getUrl()) && elementOnNeruhomist.isDisplayed());
        driver.close();
        driver.switchTo().window(parentHandle);
        return true;
    }

    public boolean checkOpenLinkAutotovary(String linkName, String expectedTitle, String expectedUrl) {
        String parentHandle = driver.getWindowHandle();
        waitVisibility(autotovary).click();
        waitPageToLoad(driver, 10);
        for (String winHandle : driver.getWindowHandles()) {
            waitPageToLoad(driver, 10);
            driver.switchTo().window(winHandle);
            waitPageToLoad(driver, 10);
        }
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(getTitle()) && expectedUrl.equalsIgnoreCase(getUrl()) && elementOnAutotovary.isDisplayed());
        driver.close();
        driver.switchTo().window(parentHandle);
        return true;
    }

    public boolean checkOpenLinkAutozapchastiny(String linkName, String expectedTitle, String expectedUrl) {
        String parentHandle = driver.getWindowHandle();
        waitVisibility(autozapchastiny).click();

        waitPageToLoad(driver, 10);
        for (String winHandle : driver.getWindowHandles()) {
            waitPageToLoad(driver, 10);
            driver.switchTo().window(winHandle);
            waitPageToLoad(driver, 10);
        }
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(getTitle()) && expectedUrl.equalsIgnoreCase(getUrl()) && elementOnAutozapchastiny.isDisplayed());
        driver.close();
        driver.switchTo().window(parentHandle);
        return true;
    }
}
