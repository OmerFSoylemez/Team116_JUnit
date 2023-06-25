package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class test_handleWindows extends TestBaseQuit {

    // ● Yeni bir class olusturun: WindowHandle
    // ● Amazon anasayfa adresine gidin.
    // ● Sayfa’nin window handle degerini String bir degiskene atayin
    // ● Sayfa title’nin “Amazon” icerdigini test edin
    // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    // ● Sayfa title’nin “wisequarter” icerdigini test edin
    // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    // ● Sayfa title’nin “Walmart” icerdigini test edin
    // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void Test01 () {

        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");


        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonwHD = driver.getWindowHandle();


        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedtitle = "Amazon";
        String actualtitle = driver.getTitle();
        Assert.assertTrue(actualtitle.contains(expectedtitle));


        // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");


        // ● Sayfa title’nin “wisequarter” icerdigini test edin
        expectedtitle  ="wisequarter";
        actualtitle= driver.getTitle();
        Assert.assertTrue(actualtitle.contains(expectedtitle));
        bekle(3);


        // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");


        // ● Sayfa title’nin “Walmart” icerdigini test edin
        expectedtitle  ="Walmart";
        actualtitle= driver.getTitle();
        Assert.assertTrue(actualtitle.contains(expectedtitle));
        bekle(3);


        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonwHD);
        String expectedUrl = "https://www.amazon.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }
}
