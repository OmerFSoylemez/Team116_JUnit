package tests.day12_ScreenShot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C01_ReusableMethodsTumSayfaSS extends TestBase {

    @Test
    public void test01() {

        //wisequarter ana sayfaya gisin
        driver.get("https://www.wisequarter.com");

        //url in wise icerdiğini test edin
        String expectedUrlIcerik = "wise";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // tum sayfa screenshot alın
        ReusableMethod.tumSayfaFotoCek(driver);

    }
}
