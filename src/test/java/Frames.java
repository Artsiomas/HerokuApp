import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Frames extends BaseTest {
    public static final String URL_FRAMES = "http://the-internet.herokuapp.com/frames";

    @Test
    public void checkTextInFrame() {
        driver.get(URL_FRAMES);
        driver.findElement(By.linkText("iFrame")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mceu_13")));
        driver.switchTo().frame("mce_0_ifr");
        String foundtext = driver.findElement(By.id("tinymce")).getText();
        assertEquals(foundtext, "Your content goes here.");
    }
}
