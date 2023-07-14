package practice;

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
        WebElement searchBox = driver.findElement(By.id("twotabsearchtexbox"));
        actions.click(searchBox)
                .sendKeys("i").sendKeys("p").keyUp("home").keyDown("XR").sendKeys(Keys.ENTER).perform();

    }
}
