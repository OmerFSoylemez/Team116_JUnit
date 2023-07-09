package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeybordbaseActions extends TestBase {

    @Test
    public void test01() {
        /*
            Her ne kadar klavyede pek çok tuş olsada
            bir tuş için yapılabilecek üç temel işlev var.
            1- tek seferlik basmak sendkeys(Keys.ENTER)
            2- Bazen belirli bir süre için bir tuşu basili tutmak isteriz keyDown()
            3- Basili tuttuğumuz tuşu serbest bırakmak isteriz keyUp()

         */

        // 2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");


        // 3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);

        actions.click(aramakutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("ambung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        // 4- aramanin gerceklestigini test edin
        bekle(5);
        String expectedIcerik = "Samsung A71";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualYazi = sonucYazisiElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedIcerik));
    }
}
