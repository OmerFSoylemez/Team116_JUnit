package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.day10_waits_cookies_webTables.Test1_ExplicitWait;
import utilities.TestBaseQuit;

public class P11_iframe extends TestBaseQuit {

    @Test
    public void iframeTest () {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement sayfadakiYazi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfadakiYazi.isDisplayed());
        System.out.println(sayfadakiYazi.getText());

        // iframe olan sayfada iframe içindeki herhangi bir şeyi test edebilmek için
        // önce iframe penceresine geçmek gerekir

        WebElement iframeCercevesi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeCercevesi); // iframe penceresine geçiş yapıyoruz

        WebElement iframeYazisi = driver.findElement(By.id("tinymce"));
        String iframedekiYazi = iframeYazisi.getText();
        System.out.println(iframedekiYazi);
        iframeYazisi.clear();
        iframeYazisi.sendKeys("have a wise day");






    }
}
