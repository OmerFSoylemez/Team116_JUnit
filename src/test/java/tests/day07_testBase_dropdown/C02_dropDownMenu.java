package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C02_dropDownMenu extends TestBase {


    @Test
    public void test01() {


        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusunun yanındaki dropdown menude 28 seçenek olduğunu test edin
        //dropdown menuyu locate et
        WebElement dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));

        // select Class ından bir obje oluşturalım
        Select select = new Select(dropdownMenuElementi);

        int expectedOptionSayisi = 28;
        int actualOptionSayisi = select.getOptions().size();

        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);
        bekle(3);

        // dropdown menuden Baby kategorisini secin
        select.selectByVisibleText("Baby");


        // arama kutusuna Nutella yazıp aratin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);


        // bulunan sonuç yazısını 5 dan fazla olduğunu test edin
        String sonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();

        String sonucSayisiStr = sonucYazisi.substring(0, sonucYazisi.indexOf(" ")); // "8"
        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr); // int olarak 8

        Assert.assertTrue(sonucSayisiInt > 5);


        // sectiğiniz opsiyonu yazdırın

            /*
            Biz daha önce dropdown menüyü locate etmiş
            ve bu menüyü kullanarak select objesi oluşturmuştuk

            ANCAK
            arama yaptırdığımızda HTML kodlar yenilendiği için
            eski elementleri BULAMAYABİLİR
            bu durumda "stale element" / bayat element uyarısı verir

            Yapmamız gereken:
            Yeniden obje oluşturmak değil
            var ollan objelere
            ayni değerleri tekrar atamaktır

             */
        dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropdownMenuElementi);
        System.out.println(select.getFirstSelectedOption().getText());


        // seçtğimiz opsiyonun Baby olduğunu test edin

        String expectedSeciliOption = "Baby";
        String actualSeciliOpton = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOptionSayisi, actualSeciliOpton);

        bekle(3);


    }
}
