package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistsTest extends TestBase {

    @Test
    public void test01() {

        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        // 3. avatar.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='avatar.png']")).click();
        bekle(5);


        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // önce dosyanın indirleceği dosya yolunu dinamik olarak oluşturalım

        String dinamikDosyaYolu = System.getProperty("user.home") +"/Dowloads/avatar.png";
        //                         herkesin bilgisayarında farklı kısım + herkes için aynı kısım

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        bekle(3);


    }
    @Test
    public void masaustu() {
        // avatar resmini masaustune kopyalayalım
        // masaustunde avatar dosyası olduğunu test edin

        String dinamikDosyaYolu = System.getProperty("user.home")+"/Desktop/avatar.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        bekle(3);
    }
}
