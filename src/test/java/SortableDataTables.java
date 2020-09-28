import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SortableDataTables {


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
    public void inputTest() {
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement firstColumnFirstCell = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        assertEquals(firstColumnFirstCell.getText(), "Smith");
        WebElement firstColumnSecondCell = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals(firstColumnSecondCell.getText(), "John");
        WebElement ForthColumnThirdCell = driver.findElement(By.xpath("//table//tr[4]//td[3]"));
        assertEquals(ForthColumnThirdCell.getText(), "tconway@earthlink.net");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

