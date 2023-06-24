package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseQuit;

import java.util.Set;

public class C04_SwitchingWindow extends TestBaseQuit {

    @Test
    public void test01() {

        //  ● https://the-internet.herokuapp.com/windows adresine gidin.
        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        //  ● Click Here butonuna basın.
        //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        //  ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingYaziElementi = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectedYazi = "Opening a new window";
        String actualYazi = openingYaziElementi.getText();

        Assert.assertEquals(expectedYazi, actualYazi);

        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        // gorevde bu sayfaya geri donüs olduğu için handle değerini kaydedelim
        String ilkSayfaWHD = driver.getWindowHandle();


        //  ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            Kontrolümüz dışında yeni bir tab veya window açılınca
            driver otamatik olarak oraya geçmez

            Yeni sayfaya geçebilmek için '2. sayfanın window handle değerini
            Bunun için dr

            1- İlk sayfada iken ilk sayfa window handle değerini kaydedelim
            2- Yeni sayfayı açan linki tıklayalım
            3- İlk ve ikinci sayfanın window handle değerlerini bir set olarak kaydededlim
               Set<String> wHDSeti = driver.getWindowHandels();
            4- Bir for-each loop ile setteki windowhandle değerlerini ilk sayfanın window handle değeri ile karşılaştıralım
               İlk sayfa windowshandle değerine eşit OLMAYAN window handle değerini
               ikinci sayfa windowhandle olarak kaydedelim
            5- bulduğumuz İkincisayfaWHD nı kullanarak 2.sayfaya geçelim
         */

        Set<String> wHDSeti = driver.getWindowHandles();
        System.out.println(wHDSeti);

        String ikinciSafyaHandle = "";
        for (String each : wHDSeti
        ) {
            if (!each.equals(ilkSayfaWHD)) {
                ikinciSafyaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSafyaHandle);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);


        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


        bekle(5);


    }
}
