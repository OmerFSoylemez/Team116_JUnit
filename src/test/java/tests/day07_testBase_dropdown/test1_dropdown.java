package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseQuit;

public class test1_dropdown extends TestBaseQuit {

        // ● Bir class oluşturun: C3_DropDownAmazon
        // ● https://www.amazon.com/ adresine gidin.
        //             - Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        // oldugunu test edin
        //              -Test 2
        // 1. Kategori menusunden Books secenegini secin
        // 2. Arama kutusuna Java yazin ve aratin
        // 3. Bulunan sonuc sayisini yazdirin
        // 4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void Test01 () {

        // ● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //             - Test 1

        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        // oldugunu test edin
        bekle(3);
        WebElement dropDownMenuElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenuElementi);
        int expectedSayi = 28;
        int actualSayi = select.getOptions().size();

        Assert.assertEquals(expectedSayi,actualSayi);
        bekle(2);

        //              -Test 2
        // 1. Kategori menusunden Books secenegini secin
        bekle(2);
        select.selectByVisibleText("Books");
        bekle(5);


        // 2. Arama kutusuna Java yazin ve aratin
        bekle(5);
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("Java" + Keys.ENTER);
        bekle(5);


        // 3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.className("sg-col-inner"));
        System.out.println("Bulunan sonuç sayisi: " + sonucSayisi.getText());



        // 4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucSayisi.getText().contains("Java"));

    }
}

