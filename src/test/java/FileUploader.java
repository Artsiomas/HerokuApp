import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.assertEquals;


public class FileUploader extends BaseTest {
    public static final String URL_FILE_UPLOADER = "http://the-internet.herokuapp.com/upload";

    @Test
    public void fileUploader() {
        driver.get(URL_FILE_UPLOADER);
        File file = new File("src/test/resources/Изображение_верблюда.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        String nameFile = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(nameFile, "Изображение_верблюда.jpg");
    }
}
