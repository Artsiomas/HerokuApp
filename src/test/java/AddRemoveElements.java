import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AddRemoveElements {
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
    public void addRemoveElements () {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        List<WebElement> addButton = driver.findElements(By.tagName("button"));
        addButton.get(0).click();
        addButton.get(0).click();
        List<WebElement> removeButton = driver.findElements(By.className("added-manually"));
        removeButton.get(1).click();
        removeButton = driver.findElements(By.className("added-manually"));
        assertEquals(removeButton.size(), 1);

    }

   @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

