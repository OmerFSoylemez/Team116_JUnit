package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P10_SwitchTo extends TestBase {

    /*
        1-Gerekli ayarlamaları yapın
        2-google.com adresine gidin
        3-Google title'ın Google içerdiğini test edin
        4-Yeni bir pencerede wisequarter sayfasına gidelim
        5-wisequarter sayfasının title'nın wise içerdiğini test edin.

     */
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.google.com");
        String ilkSayfaWHD = driver.getWindowHandle();
        System.out.println("İLk sayfanın açıldığı handle değeri "+ ilkSayfaWHD);
        String expectedWords = "Google";
        String actualTitle = driver.getTitle();
        Thread.sleep(3000);
        Assert.assertTrue(actualTitle.contains(expectedWords));
        driver.switchTo().newWindow(WindowType.WINDOW);// yeni bir pencere açıyor
        Thread.sleep(2000);
        driver.get("https://www.wisequarter.com");// yeni açılan pencerede adrese gidiyor
        String ikinciPencereWHD= driver.getWindowHandle();
        System.out.println("İkinci pencere WHD : " +ikinciPencereWHD);
        String expectedWords2 = "Wise";
        String actualTitle2 = driver.getTitle();
        Assert.assertTrue(actualTitle2.contains(expectedWords2));

        driver.switchTo().window(ilkSayfaWHD);// WHD verilen pencereye gidiyor
        driver.get("https://www.amazon.com");
        String expectedWords3 = "Amazon";
        String actualTitle3 = driver.getTitle();
        Assert.assertTrue(actualTitle3.contains(expectedWords3));

        driver.switchTo().newWindow(WindowType.TAB);// yeni bir sekme açıyor
        driver.get("https://www.wisequarter.com"); // yeni açılan sekmede adrese gidiyor
        String expectedWords4 = "Amazon";
        String actualTitle4 = driver.getTitle();
        Assert.assertFalse(actualTitle4.contains(expectedWords4));




    }

}
