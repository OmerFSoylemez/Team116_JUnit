package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_AfterClassNotasyonlari {

    /*
        Bir class daki test methodları birbiri ile bağlantılı ise
        birin çalışabilmesi için önceki test methodunun çalışması gerekiyorsa
        yani test methodları bağımasız olarak çalıştırılmayacaksa

        @Before class ve @After Class notasyonlarını kullanabilriz
        ANCAK...
        Bu notasyonlara sahip methodların static olması gerekir.


     */

    // Üç farklı test methodu oluşturup;verilen testleri yapın
    // 1-url'nin amazon içerdiğini test edin
    // 2-Nutellla arattırın ve sonuçların nutella içerdiğini test edin
    // 3-İlk ürüni click yapıp ürün isminin Nutella içerdiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @AfterClass
    public static void teardown(){

        driver.close();
    }


    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1-url'nin amazon içerdiğini test edin

        String expectedurlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedurlIcerik)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi PASSED");
            throw new RuntimeException();
        }
    }


    @Test
    public void test02(){
        //2-Nutellla arattırın ve sonuçların nutella içerdiğini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Nutella";
        String actualYazi = sonucYaziElementi.getText();

        if(actualYazi.contains(expectedIcerik)){
            System.out.println("Icerik testi PASSED");
        }else {
            System.out.println("Icerik testi FAİLED");
            throw new RuntimeException();
        }

    }
    @Test
    public void test03(){
        //3-İlk ürünü click yapıp ürün isminin Nutella içerdiğini test edin

        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        WebElement urunIsimElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedIcerik= "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        if(actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("Urun İsim testi PASSED");
        }else {
            System.out.println("Urun İsim testi FAİLSED");
            throw new RuntimeException();
        }

    }
}
