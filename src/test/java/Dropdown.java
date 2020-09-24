import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Dropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown () {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        select.selectByVisibleText("Option 2");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

        /*
        dropdown.click();
        dropdown.sendKeys(Keys.ARROW_DOWN);
        dropdown.click();
        assertEquals(dropdown.getAttribute("value"),"1");
        dropdown.sendKeys(Keys.ARROW_DOWN);
        dropdown.click();
        assertEquals(dropdown.getAttribute("value"),"2");
*/
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
