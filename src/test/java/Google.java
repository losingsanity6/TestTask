import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Google {

    @Test
    public void checkTitleTest() {
        System.setProperty("webdriver.chrome.driver", "H:\\Testing\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");

        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.sendKeys("Automation");
        searchBar.sendKeys(Keys.RETURN);

        WebElement link = driver.findElement(By.xpath(" //*[@id=\"vn1s0p1c0\"]"));
        link.click();
        String expectedTitle = driver.getTitle();
        expectedTitle.contains("Automation");

        driver.close();
    }

    @Test
    public void checkForDomainTest() {
        System.setProperty("webdriver.chrome.driver", "H:\\Testing\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");

        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.sendKeys("Automation");
        searchBar.sendKeys(Keys.RETURN);

        for (int i = 0; i < 5; i++) {
            try {
                WebElement googleLink = driver.findElement(By.partialLinkText("Test automation day"));
                if (googleLink.isDisplayed() && googleLink.isEnabled()) {
                    googleLink.click();
                    Assert.assertEquals("https://testautomationday.com", driver.getCurrentUrl());
                    break;
                }
            } catch (Exception e) {
                WebElement next = driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]"));
                next.click();
            }
        }
       Assert.fail("Page was not found");
    }
}
