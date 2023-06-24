package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void test01() {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        // konsolda yazdirin.
        WebElement anIframeElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElement.isEnabled());

        System.out.println(anIframeElement.getText());
        // - Text Box’a “Merhaba Dunya!” yazin.

        /*
            Text Box elementi gözümüzün önünde olmasına
            ve rahatça locate edilebilmesine rağmen direk kullanılamıyor

            Html kodları incelendiğinde textbox ın iframe içerinde olduğu gördük
            TextBox ı kullanmadan iframe e geçiş yapmalıyız
         */

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.tagName("p"));// locate eminsek ve buna rağman kullanamıyorsak
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya");


        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        // gorunur oldugunu dogrulayin ve konsolda yazdirin.

        /*
            Bir iFrame e geçiş yapıldıysa normal sayfada işlem yapılamaz
            Normal sayfada işlem yapmak isterseniz
            iFrame den çıkmak gerekir

            default content : ana sayfaya çıkar
            parentFrame     : eger ic ice İFrame ler varsa bir üst frame e çıkar
         */

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text() ='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());

        elementalSeleniumElementi.click();

        bekle(3);
    }
}
