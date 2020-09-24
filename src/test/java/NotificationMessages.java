import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class NotificationMessages {


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
    public void notificationMessage () {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement notificationMessage = driver.findElement (By.xpath(".//*[text()='Click here']"));
        notificationMessage.click();
        WebElement searchAndCompareNotification = driver.findElement(By.xpath("//div[@id='flash']/.."));
        assertEquals(searchAndCompareNotification.getText(), "Action successful\n×");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
