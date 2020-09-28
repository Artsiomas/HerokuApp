import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Typos {
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
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.xpath("//div[@class='example']"));
        String value = typos.getText();
        assertEquals(value, "Typos\n" + "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" + "Sometimes you'll see a typo, other times you won't.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
