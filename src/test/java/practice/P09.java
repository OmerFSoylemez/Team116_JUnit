package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P09 {

    //Js Alert Kullanımı

    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


        @After
        public void tearDown() {
            driver.close();
        }


    @Test
    public void test01() throws InterruptedException {


        // 1. Test
        // -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);

        // -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert = "I am a JS Alert";
        Assert.assertEquals(expectedAlert, actualAlert);

        // -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedSonucYazisi = "You successfully clicked an alert";
        String actualSonucYazisi = sonucYazisi.getText();
        System.out.println(sonucYazisi.getText());
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);
    }

    @Test
    public void Test01() throws InterruptedException {
        // 2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        // - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String ecxpectedConfirmYazisi = "You clicked: Cancel";
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
        String actualConfirmYazisi = sonucYazisi.getText();
        System.out.println(sonucYazisi.getText());
        Assert.assertEquals(ecxpectedConfirmYazisi, actualConfirmYazisi);
    }

    @Test
    public void test03() throws InterruptedException {
        // 3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        // - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


        // - Cikan prompt ekranina "Abdullah" yazdiralim
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);


        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();


        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String ecxpectedConfirmYazisi = "Abdullah";
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[text()='You entered: Abdullah']"));
        String actualSonucYazisi = sonucYazisi.getText();
        System.out.println(sonucYazisi.getText());
        Assert.assertTrue(actualSonucYazisi.contains(ecxpectedConfirmYazisi));



    }
}
