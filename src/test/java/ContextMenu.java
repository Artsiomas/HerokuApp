import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenu extends BasePageTest {

    public static final String URL_CONTEXT_MENU = "http://the-internet.herokuapp.com/context_menu";


    @Test
    public void useRightClickValidationAlertAndClose() {
        driver.get(URL_CONTEXT_MENU);
        WebElement contextBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextBox).perform();
        try {
            assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {

        }
    }

}
