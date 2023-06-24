package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnitTestNotasyonu {

    /*
        Junit in bize kazandırdığı en önemli yeniliklerden biri
        @Test notasyonudur.

        Notasyon (annotaion) kucuk bilgiler(meta data) barındıran yapılardır.
        sadece bir yazi ya da gösterim değillerdir
        yaptiklari islemler vardir

        @Test notasyonu sıradan bir method u
        tek basına çalıtırılabilir bir test method una dönüştürür

        Junit ile test methodları istersek tek başına,
        istersekte class level dan çalıştırılıp
        tüm testlerin birlikte çalışabileceği bir yapıya dönüşür

        Junit class içerindeki test methodlarının
        belirsiz bir sırada çalıştırır
        Test methodlarının hangi sıra ile çalışacağının
        ÖNGÖREMEYİZ ve DÜZENLEYEMEYİZ

     */

    // Bir class da 3 faklı PASSED olsa
    // ve ben testleri istersem toplu istersem bağımsız olarak çalıştırabilsem


    @Test
    public void amazontesti() {
        // amazon'a gidelim ve url in amazon içerdiğini test edip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");


        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Amazon url testi PASSED");
        } else {
            System.out.println("Amazon url testi FAİLED");
        }
        // sayfayı kapatalım
        driver.close();
    }

        @Test
        public void wisequarterTesti(){

        // Wise quarter anasayfaya gdip
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.wisequarter.com");


            // Title'ın Wise Quarter içerdiğini test edin
            String expectedTitleIcerik = "wisequarter";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitleIcerik)) {
                System.out.println("wisequarter url testi PASSED");
            } else {
                System.out.println("wisequarter url testi FAİLED");
            }


            // ve sayfayı kapatın
            driver.close();

        }
    }




