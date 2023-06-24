package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_Allerts extends TestBase {
    /*
        Bir test çalışırken
        web sayfası bize uyarı verebilir(alert)

        EGER bu uyarıyı sağ click ile inspect edebiliyorsak
        bu bir HTML alert'tir
        ve diger tüm HTML WebElement'ler gibi
        locate edilerbilir ve kullanılabilirler

        ANCAK
        sag click yapıp inspect edemiyorsak
        bunlar javascript alert olabilirler

        Js alert ler locate edilemez
        sadece driver'ımızı o alert lere switch yapıp
        o alert lerde istenilen işlemleri yapabiliriz

     */

        //   1. Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //   - 1.alert’e tiklayin
        //   - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        //   - OK tusuna basip alert’i kapatin
        //   2.Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //   - 2.alert’e tiklayalim
        //   - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        //   3.Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //   - 3.alert’e tiklayalim
        //   - Cikan prompt ekranina “Abdullah” yazdiralim
        //   - OK tusuna basarak alert’i kapatalim
        //   - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void test01() {
        //   1. Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        bekle(3);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //   - 1.alert’e tiklayin
        bekle(3);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //   - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actualalertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertYazisi,actualalertYazisi);

        //   - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
        bekle(3);

    }
    @Test
    public  void test02() {
        //   2.Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //   - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //   - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();

        String ecpectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals(ecpectedSonucYazisi,actualSonucYazisi);

    }
    @Test
    public void test03() {
        //   3.Test
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //   - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //   - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //   - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();

        //   - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String ecpectedSonucIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(ecpectedSonucIcerik));



    }
}
