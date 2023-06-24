package tests.day05_maven_JUnitFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        /*
            Seleniun 4.7.0 ile Selenium kendi WebDriver'ını oluşturma
            ve kullanabilme imkanı verdi

            Tüm şirketler Selenium WebDriver'ı kullanmayabilir.
            Sirketlerde eskiden beri kullanılan bir driver varsa
            onu projemize eklememiz ve kullanmamız istenebilir

            Böyle bir durumda istenen Web Driver'i da
            pom.xml'e eklememiz gerekir.
            pom.xml'e ekledikten sonra her class'da
            web driver objesi oluşturmadan önce
            yüklediğimiz WebDriver ile ilgili setup ı çalıştırmalıyız
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);
        driver.close();

    }
}
