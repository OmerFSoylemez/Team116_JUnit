package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_JUnitOtomatikRaporlama {

        /*
            JUnit framework'unde
            bir class veya test method'u çalıştırıldığında
            Junit tüm class veya istenen method'un
            sorunsuz olarak sonuna kadar çalışıp çalışmadığını kontrol eder

            -sorunsuz çalışırsa test PASSED
            -kodlar sorun çıktığı için çalıştırılmazsa test FAİLED
            olarak işaretlenir

            Eger if-else ile yaptığımız testlerde
            JUnit 'in raporlarininda test sonuçlari ile uyumlu olmasini isterseniz
            FAİLED durumlarinda throw keyword ile herhangi exception oluşturabiliriz

         */

    @Test
    public void amazontesti() {
        // amazon'a gidelim ve url in mazon içerdiğini test edip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");


        String expectedUrlIcerik = "Ramazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Amazon url testi PASSED");
        } else {
            System.out.println("Amazon url testi FAİLED");
            throw new RuntimeException();

        }
        // sayfayı kapatalım
        driver.close();
    }

    @Test
    public void wisequarterTesti() {

        // Wise quarter anasayfaya gdip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");


        // Title'ın Wise Quarter içerdiğini test edin
        String expectedUrlIcerik = "wisequarters";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("wisequarter url testi PASSED");
        } else {
            System.out.println("wisequarter url testi FAİLED");
            throw new RuntimeException();
        }


        // ve sayfayı kapatın
        driver.close();

    }
}


