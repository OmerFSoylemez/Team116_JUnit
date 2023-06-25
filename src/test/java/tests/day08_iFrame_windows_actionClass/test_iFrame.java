package tests.day08_iFrame_windows_actionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class test_iFrame extends TestBase {
    /*
         // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
         // 2) sayfadaki iframe sayısını bulunuz.
         // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
         // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
         // 5) ikinci iframe'deki (Jmeter Made Easy) linke
         //    (https://www.guru99.com/live-selenium-project.html) tıklayınız
     */

    @Test
    public void Test01 () {
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        bekle(3);
        driver.get("http://demo.guru99.com/test/guru99home/");



        // 2) sayfadaki iframe sayısını bulunuz.
        bekle(2);
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        int iframesayi = iframeSayisi.size();
        System.out.println("iframe sayısı : " + iframesayi);



        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        bekle(5);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        element.click();
        bekle(5);


        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        bekle(5);
        driver.switchTo().defaultContent();


        // 5) ikinci iframe'deki (Jmeter Made Easy) linke
        //    (https://www.guru99.com/live-selenium-project.html) tıklayınız
        bekle(5);
        WebElement iframe2 = driver.findElement(By.xpath("/html/body/iframe[2]"));
        driver.switchTo().frame(iframe2);
        driver.get("https://www.guru99.com/live-selenium-project.html");
        bekle(5);

    }
}




