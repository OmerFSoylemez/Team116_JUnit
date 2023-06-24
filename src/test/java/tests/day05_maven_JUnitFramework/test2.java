package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    // 2- https://www.google.com/ adresine gidin
    driver.get("https://www.google.com/");


    // 3- cookies uyarisini kabul ederek kapatin
    // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        WebElement google = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        if(google.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAİLED");
        }


    // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramacubugu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramacubugu.sendKeys("Nutella");
        aramacubugu.submit();

    // 6- Bulunan sonuc sayisini yazdirin
    // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    // 8- Sayfayi kapatin
}
}