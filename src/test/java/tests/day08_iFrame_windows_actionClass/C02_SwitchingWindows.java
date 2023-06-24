package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C02_SwitchingWindows extends TestBaseQuit {

    @Test
    public void test01() {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // url'in amazon içerdiğini test edin
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        bekle(2);

        // Yeni bir tab olarak Wise Quarter ana sayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        // title ın wise içerdiğini test edin
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // yeni bir window açarak youtube sayfasına gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        bekle(3);


        // url'in youtube icerdigini test edin
        expectedUrl = "youtube";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        // acilan tum sayfalari kapatin


    }
}
