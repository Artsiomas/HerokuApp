import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControl extends BaseTest {
    public static final String URL_DYNAMIC_CONTROL = "http://the-internet.herokuapp.com/dynamic_controls";

    @Test
    public void dynamicControl() {
        driver.get(URL_DYNAMIC_CONTROL);
        WebElement findCheckbox = driver.findElement(By.id("checkbox"));
        List<WebElement> button = driver.findElements(By.tagName("button"));
        button.get(0).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        WebElement findInput = driver.findElement(By.cssSelector("[type=text]"));
        assertFalse(findInput.isEnabled(), "поле ввода должно быть отключено");
        button.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled')]")));
        assertTrue(findInput.isEnabled(), "поле ввода должно отображаться");
    }
}
