package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeTest_AfterTestNotasyonlari {

    /*

    Junit ile class daki her test method u çalışmaya başlamasdan önce
    çalışmasını istediğimiz metodları
    @Before
    her test methodundan sonra çalışmalsını istediğimiz methodları ise
    @After
    notasypnu ile işaretleriz

    Böylece test method 'u çalışmaya başlarken
    ekstradan methodCall yapmaya gerek olmadan
    @Before notasyonuna sahip method çalışır

    test method'u bitince hiçbir methodCall olmaksızın
    @After notasyonuna sahip method çalışır

    Bu class, class level'dan çalıştırıldığında
    class'daki method'lar toplam kaç kere çalışmış oldu?
    @Before
    amazon
    @After
    @Before
    wiseQuarter
    @After
    @Before
    youtube
    @After

    sadece yputube test method'unu çalıştırmak istersek
    @Before
    youtube

     */


    WebDriver driver;

    @Test
    public void amazontesti() {
        // amazon'a gidelim ve url in mazon içerdiğini test edip

        driver.get("https://www.amazon.com");

        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Amazon url testi PASSED");
        } else {
            System.out.println("Amazon url testi FAİLED");
            throw new RuntimeException();

        }

    }

    @Test
    public void wisequarterTesti() {

        // Wise quarter anasayfaya gdip

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


    }

    @Test
    public void youtubeTesti() {
        //youtube anasayfaya gidin

        driver.get("https://www.youtube.com");
        // Title'ın youtube olduğunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("YoutubeTesti PASSED");
        } else {
            System.out.println("YoutubeTesti FAİLED");
            throw new RuntimeException();
        }
    }
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    // teardown==> sonunu bağla kapat
    }
}

