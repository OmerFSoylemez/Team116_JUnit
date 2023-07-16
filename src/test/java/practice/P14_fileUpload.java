package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P14_fileUpload extends TestBase {

    @Test
    public void fileUpload () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseButton = driver.findElement(By.id("file-upload"));

        String dosyaYolu = "C:/Users/asus/Desktop/wise1.jpg";

        chooseButton.sendKeys("src/test/java/practice/wise1.jpg");
        Thread.sleep(3000);
        driver.findElement(By.id("file-upload")).click();
        bekle(2);
        WebElement uploadedYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(uploadedYazisi.isDisplayed());
    }
}
