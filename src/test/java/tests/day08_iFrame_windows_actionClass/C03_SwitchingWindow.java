package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        String wHDAmazon= driver.getWindowHandle();

        // yeni bir tab olarak wisequarter a gidelim

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String wHDWise = driver.getWindowHandle();

        // yeni bir sayfa olarak yutube a gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String wHDYoutube = driver.getWindowHandle();

        // amazon un açık olduğu sayfaya dönün ve URL in amazon içerdiğini test edin
        driver.switchTo().window(wHDAmazon);
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        bekle(2);

        // wisequarter ın açık olduğu sayfaya gidin ve title ın wise içerdiğini test edin
        driver.switchTo().window(wHDWise);
        String expectedUrl1 = "wise";
        String actualUrl1 = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl1.contains(expectedUrl1));
        bekle(2);


        // youtube un açık olduğu sayfaya gidin ve Url in youtube içerdiğini test edin
        driver.switchTo().window(wHDYoutube);
        String expectedUrl2 = "youtube";
        String actualUrl2 = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl2.contains(expectedUrl2));


        bekle(2);


    }
}
