package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class test1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Class Work Amazon Search Test
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");


        // 2- arama kutusunu locate edelim
        driver.findElement(By.id("twotabsearchtextbox"));


        // 3- “Samsung headphones” ile arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung headphones");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);


        // 4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucsayısı = driver.findElements(By.xpath("//img[@class='s-image']"));
        System.out.println(sonucsayısı.size());


        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='aok-relative'])[1]")).click();



        // 6- Sayfadaki tum basliklari yazdiralim

        //????????????????????????????

    }
}
