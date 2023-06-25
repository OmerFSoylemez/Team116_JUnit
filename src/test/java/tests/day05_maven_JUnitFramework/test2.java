package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    // 2- https://www.google.com/ adresine gidin
    driver.get("https://www.google.com/");
    Thread.sleep(5000);

    // 3- cookies uyarisini kabul ederek kapatin
    // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        Thread.sleep(3000);
        WebElement google = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        if(google.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAİLED");
        }
        Thread.sleep(3000);

    // 5- Arama cubuguna “Nutella” yazip aratin
        Thread.sleep(3000);
        WebElement aramacubugu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramacubugu.sendKeys("Nutella");
        aramacubugu.submit();
        Thread.sleep(3000);

    // 6- Bulunan sonuc sayisini yazdirin
        Thread.sleep(3000);
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        Thread.sleep(3000);

/*
        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        Thread.sleep(3000);
        String sonucSayisi1 = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();

        String sonucSayisiStr = sonucSayisi1.substring(0,sonucSayisi1.indexOf(" "));
        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        Assert.assertTrue(sonucSayisiInt>10000000);
*/
        // 8- Sayfayi kapatin
        driver.close();
        Thread.sleep(3000);


}
}
