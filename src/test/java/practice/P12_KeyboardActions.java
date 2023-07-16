package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P12_KeyboardActions extends TestBase {

    @Test
    public void AmazonArama() {
        driver.get("https://www.amazon.com");
        // Amazon iPhone XR araması yaptıralım.

        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox)
                .keyUp(Keys.SHIFT).sendKeys("i").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("home").keyDown(Keys.SHIFT).sendKeys("XR").sendKeys(Keys.ENTER).perform();
        WebElement sonucKelimesi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedWords = "iPhone XR";
        String actualWords= sonucKelimesi.getText();
        Assert.assertTrue(actualWords.contains(expectedWords));

    }
}
