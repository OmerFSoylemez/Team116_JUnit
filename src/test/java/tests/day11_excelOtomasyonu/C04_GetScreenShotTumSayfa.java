package tests.day11_excelOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShotTumSayfa extends TestBase {

    @Test
    public void Test01  () throws IOException {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");


        // Nutella için arama yaptırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // Sonuclarin Nutella İçirdiğini test edin
        WebElement sonucElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualIcerik = sonucElementi.getText();

        // Tüm sayfa fotografını çekmek için 4 adima ihtiyaç var
        // 1.Adım : driver'ı takescreenshot objesine cast edelim

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : ekran resminin kaydedileceği bir file oluşturalim
        File tumSayfaSS = new File("target/ekranScreenshot/tumsayfaSS.png");

        // 3.adim : tss objesini kullanarak screenshot alalim  ve geçici bir dosyaya kaydedelim.

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4. adim: geçici dosyayi, oluşturduğumuz tumSayfaSS'e kopyalıyalim.
        FileUtils.copyFile(geciciDosya,tumSayfaSS);

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
