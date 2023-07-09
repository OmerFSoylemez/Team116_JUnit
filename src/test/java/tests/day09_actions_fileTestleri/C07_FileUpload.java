package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {

    @Test
    public void test01() {

        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        // 2.chooseFile butonuna basalim
        /*
            Eger chooseFile butonuna basarsak
            bilgisayarımızın klasor yapısı açılır
            oradan dosya seçmek için mouse u kullanamayacağımızdan
            bu yöntemle dosya upload mümkün değildir

            Bunun yerine selenium'un bize sunduğu çözümü kullanıyoruz
            chooseFile butonuna sendKeys ile
            yüklemek istediğimşz dosyanın dosya yolunu gönderiyoruz
         */

        // masaüstüne kopyaladığımız avatar.png dosyasının seçelim.

        WebElement chooseFileButonElementi= driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.home") + "Desktop/avatar.png";
        bekle(3);

        chooseFileButonElementi.sendKeys(dinamikDosyaYolu);

        bekle(10);


        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);
        
        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(fileUploadedElementi.isDisplayed());






    }
}
