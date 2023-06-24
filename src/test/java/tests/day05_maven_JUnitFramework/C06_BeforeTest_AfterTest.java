package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeTest_AfterTest {

    public class C04_JUnitTestNotasyonu {


    }
        /*
         bir class ın içinde birden fazla test methodu varsa
        hepsi bağımsız olarakta çalıştırılabilsin diye her methoda
        mahşerin 4 atlısını eklememiz gerekir

        Ancak bu işlem test methodlarını gereksiz uzattığı gibi
        Class ı da uzatır.

        Bunun yerine bir setup methodu oluşturup
        ilgili ayarları burada setup methodunda yapıp
        test methodunda sadece teste odaklanabiliriz

        Bu yöntemde scope dan kaynaklanan bir sorun oluşur

        Eğer WEb driver objesini setup methodunda oluşturusanız diğer
        test methodlarından kullanamazsınız

        Bunun yerine WebDriver ı class level da oluşturup
        setup methodunda sadece değer ataması yapıyoruz
         */

    WebDriver driver;

    @Test
    public void amazontesti() {
        // amazon'a gidelim ve url in mazon içerdiğini test edip
        setup();
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
        setup();
        driver.get("https://www.wisequarter.com");


        // Title'ın Wise Quarter içerdiğini test edin
        String expectedUrlIcerik = "wisequarter";
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

    @Test
    public void youtubeTesti() {
        //youtube anasayfaya gidin
        setup();
        driver.get("https://www.youtube.com");
        // Title'ın youtube olduğunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("YoutubeTesti PASSED");
        }else{
            System.out.println("YoutubeTesti FAİLED");
            throw  new RuntimeException();
        }
    }
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}



