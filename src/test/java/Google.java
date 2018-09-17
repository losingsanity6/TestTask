import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Google {

    private String key = "api_key=Q7qNVxdwbZV6xGmpD37IjPjy0AuCRmkYK5lNnRpd";

    @Test
    public void checkfkdfjkdjfkdjfkdj() {
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

    @Test()
    public void descriptionTest() {
        given().get("https://developers.ria.com/auto/info?" + key + "&auto_id=22304245").
                then().
                statusCode(200).
                body("autoData.description", equalTo("ЧИСТЫЙ-2013г.в. в ТП.,производство-30;09;2013г.в!!БЕЗ пробега по Украине!!ОТЛИЧНОЕ состояние-НЕ БИТ-100%!!*ОРИГИНАЛЬНЫЙ-МАЛЕНЬКИЙ пробег-1000%-гарантирован(а это-большая РЕДКОСТЬ),в наличии АКТЫ выполненных работ на СТО-06;07;2018г-сделано ПОЛНОЕ обслуживание,авто в ОТЛИЧНОМ техническом состоянии-на руках ЗАКЛЮЧЕНИЕ СЕРВИСНОГО центра!!МОЩНЫЙ и супер ЭКОНОМИЧНЫЙ двигатель 5л./100км!!БОГАТАЯ комплектация-Система динамической стабилизации;Противобуксовочная система;ПОЛНЫЙ-электропакет;Мультируль;Телефон-блютуз;Кондиционер;Бортовой компьютер с монитором;Акустическая система;Парктроники с звуковым сигналом;Электропривод зеркал+Подогрев зеркал;Подогрев стекла;Подогрев сидений;Электро-стеклоподъемники и мн.др. функций-для ВАШЕГО комфорта и безопасности!!ЦЕЛЫЙ-Живой-как технически так и визуально-готов к любым проверкам!!МОЩНАЯ,ДИНАМИЧНАЯ,ЭКОНОМНАЯ,НАДЕЖНАЯ-рабочая лошадка-для БИЗНЕСА и домашнего пользования,мягкая в ходу-ДЕШЕВЫЙ в обслуживании!!В наличии ВСЕ документы для регистрации и постановки на учет!!MIN ТОРГ!"));

    }

    @Test()
    public void markaIdTest() {
        given().get("https://developers.ria.com/auto/new/models?marka_id=9&category_id=1&" + key).
                then().
                statusCode(200).
                body("marka_id[0]", equalTo(9));

    }

    @Test()
    public void countOfPageTest() {
        given().get("https://developers.ria.com/new_to_old?" + key + "&categories.main.id=1&brand.id%5B0%5D=9&year%5B0%5D.gte=2011&year%5B0%5D.lte=2016&custom.not=1&fuel.id%5B5%5D=6&gearbox.id%5B1%5D=2&gearbox.id%5B2%5D=3&size=10%22&countpage=10").
                then().
                statusCode(200).
            //dfjkdjfhddadsasdsa
                

    }

}
