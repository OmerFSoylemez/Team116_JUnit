package tests.day12_ScreenShot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C02_WebElementScreenShot extends TestBase {

    @Test
    public void Test01 () {

        // google a gidelim
        driver.get("https://www.google.com");

        // nutella aratalım
        bekle(5);
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@name='q']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();



        // arama sonuç sayısısının screenshot ını alalım
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        ReusableMethod.webElementFotoCek(driver,aramaSonucElementi);

    }
}
