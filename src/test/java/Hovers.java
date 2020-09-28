import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Hovers {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void notificationMessage() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions builder = new Actions(driver);
        builder.moveToElement((WebElement) driver.findElements(By.className("figure")).get(0)).click().build().perform();
        List<WebElement> compareUserName = driver.findElements(By.tagName("h5"));
        assertEquals(compareUserName.get(0).getText(), "name: user1");
        List<WebElement> checklink = driver.findElements(By.xpath(".//*[text()='View profile']"));
        checklink.get(0).click();
        WebElement compareMistake = driver.findElement(By.tagName("h1"));
        assertEquals(compareMistake.getText(), "Not Found");

        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions builder1 = new Actions(driver);
        builder1.moveToElement((WebElement) driver.findElements(By.className("figure")).get(1)).click().build().perform();
        List<WebElement> compareUserName1 = driver.findElements(By.tagName("h5"));
        assertEquals(compareUserName1.get(1).getText(), "name: user2");
        List<WebElement> checklink1 = driver.findElements(By.xpath(".//*[text()='View profile']"));
        checklink1.get(1).click();
        WebElement compareMistake1 = driver.findElement(By.tagName("h1"));
        assertEquals(compareMistake1.getText(), "Not Found");

        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions builder2 = new Actions(driver);
        builder2.moveToElement((WebElement) driver.findElements(By.className("figure")).get(2)).click().build().perform();
        List<WebElement> compareUserName2 = driver.findElements(By.tagName("h5"));
        assertEquals(compareUserName2.get(2).getText(), "name: user3");
        List<WebElement> checklink2 = driver.findElements(By.xpath(".//*[text()='View profile']"));
        checklink2.get(2).click();
        WebElement compareMistake2 = driver.findElement(By.tagName("h1"));
        assertEquals(compareMistake2.getText(), "Not Found");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
