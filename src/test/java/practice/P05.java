package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    static WebDriver driver;


    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin - usd to tl
    // Karsilastirilacak olan para biriminin 30 den kucuk oldugu test edilir
    // yorum yapılabilir


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

        @Test
        public void paraKarsilastir() {
            // Kullanici https://www.google.com adresine gider
            driver.get("https://www.google.com");


            // Arama işlemini gerçekleştirelim
            WebElement searchbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            searchbox.sendKeys("usd to tl" + Keys.ENTER);
            WebElement resultElement = driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
            String result = resultElement.getText().replaceAll(",", ".");
            double sonuc = Double.parseDouble(result);
            Assert.assertTrue(sonuc < 27.0);

            if(sonuc<27){
                System.out.println("Çok şükür 27 olmadı daha");
            }else {
                System.out.println("Allah Yardımcımız Olsun");
            }

    }
    @After
    public void tearDown() {
        driver.close();

    }
}